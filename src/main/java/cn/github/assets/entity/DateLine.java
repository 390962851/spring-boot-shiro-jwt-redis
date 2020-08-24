package cn.github.assets.entity;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class DateLine {
    private String weeks;
    private String dataName;
    private Integer data;
}
