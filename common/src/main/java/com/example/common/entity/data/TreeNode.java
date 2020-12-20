package com.example.common.entity.data;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 树节点
 * @author nf
 * @since 2020/1/14 9:33
 */
@Data
@Accessors(chain = true)
public class TreeNode<T> implements Serializable {

    private static final long serialVersionUID = 6917837228271122351L;

    /**
     * 对象本身
     */
    private T self;

    /**
     * 子集
     */
    private List<TreeNode<T>> children;
}
