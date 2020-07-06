package ssm.jc.pojo;

/**
 * FileName: Role
 * Author:   haichaoyang3
 * Date:     2020/7/3 16:31
 * Description:
 * History:
 * since: 1.0.0
 */

public class Role {
    private int id;
    private String roleName;
    private String note;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
