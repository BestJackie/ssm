package spring.aop.demo;

/**
 * FileName: Role
 * Author:   haichaoyang3
 * Date:     2020/6/28 14:06
 * Description:
 * History:
 * since: 1.0.0
 */

public class Role {
    //TODO
    private Long id;
    private String rolename;
    private String note;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", rolename='" + rolename + '\'' +
                ", note='" + note + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Role(Long id, String rolename, String note) {
        this.id = id;
        this.rolename = rolename;
        this.note = note;
    }
}
