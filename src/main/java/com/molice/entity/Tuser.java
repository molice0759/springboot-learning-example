package com.molice.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author molice
 * @since 2019-03-09
 */
public class Tuser extends Model<Tuser> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 用户名称
     */
    private String staffName;
    /**
     * 员工号
     */
    private String staffNum;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 创建时间
     */
    private Date createtime;
    /**
     * 0:删除 ， 1:整除 ，2:其他
     */
    private Integer deleteflag;
    /**
     * 管理人标准
     */
    private Integer isAdmin;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffNum() {
        return staffNum;
    }

    public void setStaffNum(String staffNum) {
        this.staffNum = staffNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getDeleteflag() {
        return deleteflag;
    }

    public void setDeleteflag(Integer deleteflag) {
        this.deleteflag = deleteflag;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Tuser{" +
        ", id=" + id +
        ", staffName=" + staffName +
        ", staffNum=" + staffNum +
        ", password=" + password +
        ", createtime=" + createtime +
        ", deleteflag=" + deleteflag +
        ", isAdmin=" + isAdmin +
        "}";
    }
}
