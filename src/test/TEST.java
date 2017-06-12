package test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TEST {

	public static void main(String[] args) {
		Integer a = null;
//		System.out.println(a==1);
	}

}

class CallMethod {

	private int asd;
	private double q;
	public static void main(String[] args) {
		String classPath = new CallMethod().getClass().toString();
		classPath = classPath.replace("class ", "");
		callMethod(classPath, "test", new Object[] { 1, "s" }, "java.lang.Integer", "java.lang.String");
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
	public static Object callMethod(String className, String methodName, Object[] param, String... parameterTypeNames) {
		try {
			Class cObj = Class.forName(className);
			System.out.println("加载类: " + className);
			Class[] parameterTypeClazzs = new Class[parameterTypeNames.length];
			String parameterTypeName = "";
			for (int i = 0; i < parameterTypeNames.length; i++) {
				if (!parameterTypeName.equals("")) {
					parameterTypeName += ", ";
				}
				parameterTypeClazzs[i] = Class.forName(parameterTypeNames[i]);
				parameterTypeName += parameterTypeClazzs[i].getSimpleName();
			}
			Field[] set = cObj.getDeclaredFields();
			set[0].getName();
			Method m = cObj.getDeclaredMethod(methodName, parameterTypeClazzs);
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