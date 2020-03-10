package volodymyr;

public class Application {

	public static void main(String[] args) {

		Integer[] array = { 1, 43, 5, -12, 34, 55, 113, 390, 81, 2 };

		Collection collection = new Collection(array);

//		Iterator iteratorForward = collection.createForward();
//		
//		while(iteratorForward.hasNext()) {
//			System.out.println(iteratorForward.next());
//		}
//		
//		System.out.println();
//		
//		Iterator iteratorBackward = collection.createBackward();
//		
//		while(iteratorBackward.hasNext()) {
//			System.out.println(iteratorBackward.next());
//		}

		Iterator iteratorForward = collection.createForward();

		while (iteratorForward.hasNext()) {
			Object numberForward = iteratorForward.next();
			if (((Integer) numberForward).intValue() % 2 != 0) {
				numberForward = 0;
			}
			System.out.println(numberForward);
		}

		System.out.println();

		Iterator iteratorBackward = collection.createBackward();
		int i = 0;
		while (iteratorBackward.hasNext()) {
			Integer numberBackward = (Integer) iteratorBackward.next();
			if (i % 2 == 0) {
				System.out.println(numberBackward);
			}
			i++;
		}

		System.out.println();
		Iterator iteratorAnonymous = collection.createAnonimous();

		int j = 1;
		while (iteratorAnonymous.hasNext()) {
			Integer numberAnonymous = (Integer) iteratorAnonymous.next();
			if (j % 3 == 0) {
				if (numberAnonymous.intValue() % 2 != 0) {
					System.out.println(numberAnonymous);
				}
			}
			j++;
		}

		System.out.println();

		Iterator iteratorLocal = collection.createLocal();

		int a = 1;
		while (iteratorLocal.hasNext()) {
			Integer numberLocal = (Integer) iteratorLocal.next();
			if (a % 5 == 0) {
				if (numberLocal.intValue() % 2 == 0) {
					numberLocal = numberLocal.intValue() - 100;
					System.out.println(numberLocal);
				}
			}
			a++;
		}
		
		System.out.println();
		
		Iterator iteratorStatic = collection.createStaticIterator();
		
		int b = 1;
		while(iteratorStatic.hasNext()) {
			Integer numberStatic = (Integer) iteratorStatic.next();
			if(b % 2 == 0) {
				if(numberStatic.intValue() % 2 == 0) {
					numberStatic = numberStatic.intValue();
					System.out.println(numberStatic);
				}
			}
			b++;
		}
		
	}

}
