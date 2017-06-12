package excel;

public class TestData implements ExcelParser {
	private Long oid;
	private String name;

	public TestData(Long oid, String name) {
		super();
		this.oid = oid;
		this.name = name;
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String[] parserData() {
		return new String[] { getOid().toString(), getName() };
	}
}
