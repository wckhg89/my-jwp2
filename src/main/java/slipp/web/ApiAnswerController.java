package slipp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;
import slipp.model.*;
import slipp.utils.HttpSessionUtils;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 강홍구 on 2016-12-05.
 */
@RestController
@RequestMapping("/api/questions")
public class ApiAnswerController {

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    QuestionRepository questionRepository;

    @GetMapping("")
    public List<Question> get () {
        return questionRepository.findAll();
    }
   // /api/questions/{{question.id}}/answers/{{id}}
    @DeleteMapping("/{questionId}/answers/{id}")
    public Result delete(@PathVariable Long questionId, @PathVariable Long id, HttpSession session) {

        if (!HttpSessionUtils.isLoginUser(session)) {
            return Result.fail("Not Logined");
        }
        User loginUser = HttpSessionUtils.getUserFromSession(session);
        Answer answer = answerRepository.findOne(id);
        answer.delete(loginUser);
        answerRepository.save(answer);

        return Result.ok();
    }

    @PostMapping("/{questionId}/answers")
    public Answer create (@PathVariable Long questionId, String contents, HttpSession session) {
        if (!HttpSessionUtils.isLoginUser(session)) {
            //return "/user/login";
        }

        User loginUser = HttpSessionUtils.getUserFromSession(session);
        Question question = questionRepository.findOne(questionId);
        Answer answer = new Answer(loginUser, question, contents);
        return answerRepository.save(answer);
    }
}
