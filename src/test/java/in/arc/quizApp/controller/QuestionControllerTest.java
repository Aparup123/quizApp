package in.arc.quizApp.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class QuestionControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void saveQuestionTest() throws Exception {
        String requestBody = """
                    {
                    "content" : "Which city is capital of India?",
                    "type" : "MCQ",
                    "tags" : ["geography", "politics", "world", "general knowledge"],\s
                    "options" : [
                        {
                            "content": "New Delhi",
                            "number": 1
                        },
                        {
                            "content": "Mysore",
                            "number": 2
                        },
                        {
                            "content": "Kolkata",
                            "number": 3,
                            "correct": true
                        },
                        {
                            "content": "Mumbai",
                            "number": 4,
                            "correct": true
                        }
                    ]
                }""";

        mockMvc.perform(
                MockMvcRequestBuilders.post("/question")
                    .contentType(MediaType.APPLICATION_JSON).content(requestBody)
        ).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.content").value("Which city is capital of India?"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.options").exists());
    }
}
