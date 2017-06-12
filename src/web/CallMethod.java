package web;

import java.lang.reflect.Method;

public class CallMethod {

	public static void main(String[] args) {
		String classPath = new CallMethod().getClass().toString();
		classPath = classPath.replace("class ", "");
		callMethod(classPath, "test", new Object[] { 1, "s" }, Integer.class, String.class);
		System.out.println();
		callMethod(classPath, "test");
	}

	public void test(Integer i, String s) {
		System.out.println(i);
		System.out.println(s);

	}

	public void test() {
		System.out.println("2");
		System.out.println("s");

	}

	public static Object callMethod(String className, String methodName) {
		return callMethod(className, methodName, null);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Object callMethod(String className, String methodName, Object[] param, Class... parameterType) {
		try {
			Class cObj = Class.forName(className);
			System.out.println("加载类: " + className);
			Method m = cObj.getDeclaredMethod(methodName, parameterType);
			String parameterTypeName = "";
			for (int i = 0; i < parameterType.length; i++) {
				if (!parameterTypeName.equals("")) {
					parameterTypeName += ", ";
				}
				parameterTypeName += parameterType[i].getSimpleName();
			}
			System.out.println("加载方法: " + methodName + "(" + parameterTypeName + ")");
			System.out.println("----开始调用----");
			Object returnValue = m.invoke(cObj.newInstance(), param);
			System.out.println("----结束调用----");
			System.out.println("返回类型:" + m.getReturnType());
			if (m.getReturnType() != void.class) {
				System.out.println("返回值:" + returnValue);
			} else {
				System.out.println("无返回值");
			}
			return returnValue;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
