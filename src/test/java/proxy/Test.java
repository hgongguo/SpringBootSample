package proxy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;


public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MaotaiJiu maotaijiu = new MaotaiJiu();
		
		Wuliangye wu = new Wuliangye();
		
		Furongwang fu = new Furongwang();
		
		InvocationHandler jingxiao1 = new GuitaiA(maotaijiu);
		InvocationHandler jingxiao2 = new GuitaiA(wu);
		
		InvocationHandler jingxiao3 = new GuitaiA(fu);
		
		SellWine dynamicProxy = (SellWine) Proxy.newProxyInstance(MaotaiJiu.class.getClassLoader(),
				MaotaiJiu.class.getInterfaces(), jingxiao1);
		SellWine dynamicProxy1 = (SellWine) Proxy.newProxyInstance(MaotaiJiu.class.getClassLoader(),
				MaotaiJiu.class.getInterfaces(), jingxiao2);
		
		dynamicProxy.mainJiu();
		
		dynamicProxy1.mainJiu();
		
		SellCigarette dynamicProxy3 = (SellCigarette) Proxy.newProxyInstance(Furongwang.class.getClassLoader(),
				Furongwang.class.getInterfaces(), jingxiao3);
		
		dynamicProxy3.sell();

		System.out.println("dynamicProxy class name:"+dynamicProxy.getClass().getName());
		System.out.println("dynamicProxy1 class name:"+dynamicProxy1.getClass().getName());
		System.out.println("dynamicProxy3 class name:"+dynamicProxy3.getClass().getName());
		
	}

}

