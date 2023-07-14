package com.wm.po;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @author bilie
 * 创作者实体类
 */
@Data
@ToString
@AllArgsConstructor
@Component
public class Framer {

    /**
     * 创作者编号
     */
    private int fid;

    /**
     * 创作者名字
     */
    private String fname;

    /**
     * 创作者照片地址
     */
    private String fPictureAddress;

    /**
     * 创作类型编号
     */
    private int creationTypeid;

    public Framer() {
    }

}
