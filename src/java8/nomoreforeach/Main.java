package java8.nomoreforeach;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		/**
		 * lambda 表达式
		 */
		List<Person> javaProgrammers = new ArrayList<Person>() {
			{
				add(new Person("Elsdon", "Jaycob", "Java programmer", "male", 43, 2000));
				add(new Person("Tamsen", "Brittany", "Java programmer", "female", 23, 1500));
				add(new Person("Floyd", "Donny", "Java programmer", "male", 33, 1800));
				add(new Person("Sindy", "Jonie", "Java programmer", "female", 32, 1600));
				add(new Person("Vere", "Hervey", "Java programmer", "male", 22, 1200));
				add(new Person("Maude", "Jaimie", "Java programmer", "female", 27, 1900));
				add(new Person("Shawn", "Randall", "Java programmer", "male", 30, 2300));
				add(new Person("Jayden", "Corrina", "Java programmer", "female", 35, 1700));
				add(new Person("Palmer", "Dene", "Java programmer", "male", 33, 2000));
				add(new Person("Addison", "Pam", "Java programmer", "female", 34, 1300));
			}
		};

		List<Person> phpProgrammers = new ArrayList<Person>() {
			{
				add(new Person("Jarrod", "Pace", "PHP programmer", "male", 34, 1550));
				add(new Person("Clarette", "Cicely", "PHP programmer", "female", 23, 1200));
				add(new Person("Victor", "Channing", "PHP programmer", "male", 32, 1600));
				add(new Person("Tori", "Sheryl", "PHP programmer", "female", 21, 1000));
				add(new Person("Osborne", "Shad", "PHP programmer", "male", 32, 1100));
				add(new Person("Rosalind", "Layla", "PHP programmer", "female", 25, 1300));
				add(new Person("Fraser", "Hewie", "PHP programmer", "male", 36, 1100));
				add(new Person("Quinn", "Tamara", "PHP programmer", "female", 21, 1000));
				add(new Person("Alvin", "Lance", "PHP programmer", "male", 38, 1600));
				add(new Person("Evonne", "Shari", "PHP programmer", "female", 40, 1800));
			}
		};
		/* sort */
//		System.out.println();
//		javaProgrammers.sort((a, b) -> (b.getSalary() > a.getSalary()) ? 1 : (b.getSalary() < a.getSalary() ? -1 : 0));
//
		javaProgrammers.forEach(p -> {
			System.out.println(p);
		});
		System.out.println();

		// set
		Set<Person> sets = new HashSet<Person>(javaProgrammers);
		sets.forEach(new Consumer<Person>() { // 参考までにラムダ式未使用時
			@Override
			public void accept(Person pen) {
				pen.setSalary((int) (pen.getSalary()*1.05));
				System.out.println(pen);
			}
		});
		System.out.println();
		Consumer<Person> consumer = e -> e = null;
		sets.forEach(consumer);
		sets.forEach(str -> {
			System.out.println(str);
		});
		// map
		Map<String, String> maps = new HashMap<>();
		maps.forEach((key, value) -> System.out.println(key + ":" + value));
	}

	/**
	 * foreach 取得第一篇 java 文章
	 * 
	 * @param articles
	 * @return
	 */
	public Article getFirstJavaArticle(List<Article> articles) {
		for (Article article : articles) {
			if (article.getTags().contains("Java")) {
				return article;
			}
		}
		return null;
	}

	/**
	 * 首先使用 filter 操作去找到所有包含Java标签的文章， 然后使用 findFirst() 操作去获取第一次出现的文章。
	 * 因为Stream是“延迟计算”（lazy）的并且filter返回一个流对象， 所以这个方法仅在找到第一个匹配元素时才会处理元素。
	 * 
	 * @param articles
	 * @return
	 */
	public Optional<Article> getFirstJavaArticleEx(List<Article> articles) {
		Stream<Article> articlesStream = articles.stream();
		articlesStream = articlesStream.filter(article -> article.getTags().contains("Java"));
		return articlesStream.findFirst();
	}
}

class Person {

	private String firstName, lastName, job, gender;
	private int salary, age;

	public Person(String firstName, String lastName, String job, String gender, int age, int salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.job = job;
		this.salary = salary;
	}

	public String toString() {
		return firstName + "\t" + lastName + "\t" + gender + "\t" + age + "\t" + job + "\t" + salary;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}