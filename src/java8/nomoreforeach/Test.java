package java8.nomoreforeach;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Test {

	static List<Article> fibonacciSequence = new ArrayList<Article>();
	static List<Article> newSequence = new ArrayList<Article>();

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println(i + " - " + i%3);
		}
		System.out.println();
//		System.out.println(System.currentTimeMillis());
//		initSequience();
//		System.out.println(System.currentTimeMillis());
//		for (Article article : fibonacciSequence) {
//			if (Long.parseLong(article.getTitle())%2==0 ) {
//				newSequence.add(article);
//			}
//		}
//		System.out.println(System.currentTimeMillis());
//		System.out.println(newSequence.size());
//		newSequence.clear();
//		System.out.println(System.currentTimeMillis());
//		System.out.println(fibonacciSequence.stream().filter(article -> Long.parseLong(article.getTitle())%2==0).count());
//		System.out.println(System.currentTimeMillis());
//		System.out.println(fibonacciSequence.size());
//		newSequenceStream.
	}
	static void initSequience() {
		for (Long i = 0l; i < 1000000; i++) {
			Article article = new Article();
			article.setTitle(getNum(i).toString());
			fibonacciSequence.add(article);
		}
	}

	static Long getNum(Long i) {
		if (i < 3) {
			return 1l;
		} else {
			return Long.parseLong(fibonacciSequence.get(i.intValue() - 1).getTitle()) + Long.parseLong(fibonacciSequence.get(i.intValue() - 2).getTitle());
		}
	}
}
