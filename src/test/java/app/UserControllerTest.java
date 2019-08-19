package app;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;
    private ObjectMapper objectMapper;

    @Test
    public void getUsers() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/users").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$").isArray());
    }

    @Test
    public void getUser() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/users/1").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").exists())
            .andExpect(jsonPath("$.age").exists())
            .andExpect(jsonPath("$.email").exists());
    }

    @Test
    public void createUser() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/users/")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"name\": \"John Doe\", \"age\": 28, \"email\": \"john@example.com\"}"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name", equalTo("John Doe")))
            .andExpect(jsonPath("$.email", equalTo("john@example.com")))
            .andExpect(jsonPath("$.age", equalTo(28)));
    }

    @Test
    public void updatesUserAge() throws Exception {
        mvc.perform(MockMvcRequestBuilders.put("/users/0")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"age\": 101}"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.age", equalTo(101)));
    }

    @Test
    public void shouldDoNothingForIndexOOB() throws Exception {
        mvc.perform(MockMvcRequestBuilders.put("/users/999")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"age\": 101}"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.age").doesNotExist());
    }
}