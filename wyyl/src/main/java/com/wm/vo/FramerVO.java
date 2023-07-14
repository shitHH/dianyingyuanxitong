package com.wm.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @author bilie
 * 创作者视图实体类
 */
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class FramerVO {

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
     * 创作类型
     */
    private String creationType;

}
