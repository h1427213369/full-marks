package cn.hlsxn.fullMarks;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource(locations = {"classpath:kaptcha.xml"})
@SpringBootApplication
public class FullMarksApplication{
    public static void main(String[] args) {
        SpringApplication.run(FullMarksApplication.class);
    }
}
