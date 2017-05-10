
public class Privilege {
	private String access;

	public String getAcces() {
		return access;
	}

	public void setAcces(String access) {
		this.access = access;
	}
	
	public boolean isAccessed() {
		if ("admin".equals(this.access)) {
			System.out.println("拥有权限...");
			return true;
		}else {
			System.out.println("没有操作权限...");
			return false;
		}
	}
}
