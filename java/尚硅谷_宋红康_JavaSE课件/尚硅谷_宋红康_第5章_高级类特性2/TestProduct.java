package day10;

public class TestProduct {

	public static void main(String[] args) {
		TestProduct tp = new TestProduct();
		Product p = tp.getProduct();

		System.out.println(p.getName());
		System.out.println(p.getPrice());
		// ----------------------
		tp.showProduct(p);
		// ------------------------
		tp.showProduct(new Product() {// ������һ��������Ķ���
			public int getPrice() {
				return 7899;
			}

			public String getName() {
				return "iphone5s-������";
			}

		});
	}

	public Product getProduct() {
		// ������һ���ֲ��ڲ���Ķ���
		// class MyProduct implements Product{
		//
		// @Override
		// public int getPrice() {
		// // TODO Auto-generated method stub
		// return 3899;
		// }
		//
		// @Override
		// public String getName() {
		// // TODO Auto-generated method stub
		// return "ipad air";
		// }
		//
		// }
		// return new MyProduct();
		return new Product() {// ������һ�������ڲ���Ķ���
			public int getPrice() {
				return 7899;
			}

			public String getName() {
				return "iphone5s-������";
			}

		};
	}

	public void showProduct(Product p) {
		System.out.println(p.getName());
		System.out.println(p.getPrice());
	}
}

interface Product {
	public abstract int getPrice();

	public abstract String getName();
}