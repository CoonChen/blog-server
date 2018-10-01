package com.coon.blog.common.base.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import org.springframework.util.StringUtils;

import java.io.Serializable;

@KeySequence(value = "SEQ_ORACLE_STRING_KEY", clazz = String.class)
public class IdEntity implements Serializable {
    private static final long serialVersionUID = -864662154371775680L;
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null || id.length() == 0) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        IdEntity other = (IdEntity) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

    public Boolean isCreate() {
        return StringUtils.isEmpty(id);
    }
}
