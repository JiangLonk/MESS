package web;

public class Beer {
	
	/**
	 * 价格
	 */
	final static int PRICE = 2;
	/**
	 * 瓶盖价
	 */
	final static int CAP_PRICE = 4;
	/**
	 * 瓶价
	 */
	final static int BOTTLE_PRICE = 2;
	/**
	 * 持有的钱
	 */
	int money = 10;
	/**
	 * 持有的瓶盖
	 */
	int caps = 0;
	/**
	 * 持有的瓶子
	 */
	int bottles = 0;
	/**
	 * 持有的啤酒
	 */
	int beer = 0;
	/**
	 * 共兑换的啤酒
	 */
	int count = 0;
	
	public static void main(String[] args) {
		Beer buy = new Beer();
		buy.buyBeer();
		buy.drinkBeer();
		System.out.println();
		buy.buyBeer();
		buy.drinkBeer();
		System.out.println();
		buy.buyBeer();
		buy.drinkBeer();
		System.out.println();
		buy.buyBeer();
		buy.drinkBeer();
		System.out.println();
		buy.buyBeer();
		buy.drinkBeer();
		System.out.println();
		buy.buyBeer();
		buy.drinkBeer();
		System.out.println();
		buy.buyBeer();
		buy.drinkBeer();
		System.out.println();
		buy.buyBeer();
		buy.drinkBeer();
		System.out.println();
		buy.buyBeer();
		buy.drinkBeer();
		System.out.println();
		buy.buyBeer();
		buy.drinkBeer();
		System.out.println();
		buy.buyBeer();
		buy.drinkBeer();
		System.out.println();
		buy.buyBeer();
		buy.drinkBeer();
		System.out.println();
		buy.buyBeer();
		buy.drinkBeer();
		System.out.println();
		buy.buyBeer();
		buy.drinkBeer();
		System.out.println();
		buy.buyBeer();
		buy.drinkBeer();
		System.out.println();
		buy.buyBeer();
		buy.drinkBeer();
		System.out.println();
		buy.buyBeer();
		buy.drinkBeer();
		System.out.println();
		buy.buyBeer();
		buy.drinkBeer();
	}

	void buyBeer(){
		/**
		 * 可兑换的啤酒
		 */
		int num = 0;
		num += money / 2;
		money = money % 2;
		System.out.println("余额：" + money);
		num += (caps / 4);
		beer = (caps % 4);
		System.out.println("余盖：" + caps);
		caps = 0;
		num += (bottles / 2);
		beer = (bottles % 2);
		System.out.println("余瓶：" + bottles);
		bottles = 0;
		beer = beer + num;
		System.out.println("目前持有：" + beer);
		System.out.println("本次兑换：" + num);
		count += num;
		System.out.println("累计兑换：" + count);
	}
	
	void drinkBeer(){
		caps = caps + beer;
		bottles = bottles + beer;
		beer = 0;
	}
	
}
