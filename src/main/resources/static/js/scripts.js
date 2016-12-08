$(".answer-write input[type='submit']").click(addAnswer);
$(".qna-comment-slipp-articles").on("click", ".delete-answer-form button[type='submit']", deleteAnswer);

function deleteAnswer (e) {
    e.preventDefault();
    var url = $('.delete-answer-form').attr("action");
    var $that = $(this);
    $.ajax({
        type: 'DELETE',
        url : url,
        error : function () {
            console.log("Failed")
        },
        success : function (data, status) {
            console.log(data);
            if (!data.valid) {
                console.log("Delete Failed");
                return;
            }
            $that.closest(".article").remove();
        }
    })
}

function addAnswer(e) {
    console.log("Click Answer");
    e.preventDefault();
    var $answerWrite = $(".answer-write");

    var url = $answerWrite.attr("action");
    var queryString = $(".answer-write").serialize();

    $.ajax({
        type : 'post',
        url : url,
        data : queryString,
        dataType : 'json',
        error : function () {
            console.log("Failed")
        },
        success : function (data, status) {
            console.log(data);
            var answerTemplate = $("#answerTemplate").html();
            var template = answerTemplate.format(data.writer.userId, data.formattedCreateDate, data.contents, data.question.id, data.id);
            $(".qna-comment-slipp-articles").prepend(template);
            $("textarea[name=contents]").val("");

        }
    });

}

String.prototype.format = function() {
  var args = arguments;
  return this.replace(/{(\d+)}/g, function(match, number) {
    return typeof args[number] != 'undefined'
        ? args[number]
        : match
        ;
  });
};