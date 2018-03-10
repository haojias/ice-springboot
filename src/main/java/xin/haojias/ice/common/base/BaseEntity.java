package xin.haojias.ice.common.base;

import java.io.Serializable;

public class BaseEntity implements Serializable {

    /**
     * <p>
     * 分页页码,默认页码为1
     * <p>
     */
    protected int page;

    /**
     * <p>
     * 分页每页数量,默认20条
     * <p>
     */
    protected int size;

    /**
     * <p>
     * 排序列名称,默认为id
     * <p>
     */
    protected String sidx;

    /**
     * <p>
     * 排序正序
     * <p>
     */
    protected String sort;

}
