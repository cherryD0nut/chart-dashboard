package com.vinns.dashboard;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vinns.dashboard.entity.Student;
import com.vinns.dashboard.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations="classpath:application-test.properties")
public class TableControllerTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    StudentRepository studentRepository;

    @BeforeEach
    public void mockMvcSetUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .build();
        studentRepository.deleteAll();
    }

    @DisplayName("findAllStudents: 학생 목록 조회 테스트")
    @Test
    public void findAllStudents() throws Exception{
        // given
        final String url = "/table/all";
        final String name = "Mafuyu Asahina";
        final String gender = "female";
        final int level = 1;
        final int track = 2;

        studentRepository.save(Student.builder()
                .name(name)
                .gender(gender)
                .level(level)
                .track(track)
                .build());

        // when
        final ResultActions resultActions = mockMvc.perform(get(url)
                .accept(MediaType.APPLICATION_JSON));

        // then
        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value(name))
                .andExpect(jsonPath("$[0].gender").value(gender))
                .andExpect(jsonPath("$[0].level").value(level))
                .andExpect(jsonPath("$[0].track").value(track));
    }
}
