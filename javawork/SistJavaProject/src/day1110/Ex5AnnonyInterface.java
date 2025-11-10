package day1110;

interface Company{
	public void addSangpum();
	public void deleteSangpum();
	public void listSangpum();
}

public class Ex5AnnonyInterface {
	
	//위의 compamy인터페이스를 익명내부클래스 형식으로 선언하시오
	//각 메서드를 호출 완성해보세요.
	
	Company company=new Company() {
		
		@Override
		public void listSangpum() {
			// TODO Auto-generated method stub
			System.out.println("상품 내역");
			
		}
		
		@Override
		public void deleteSangpum() {
			// TODO Auto-generated method stub
			System.out.println("삭제할 상품명을 입력해주세요.");
			
		}
		
		@Override
		public void addSangpum() {
			// TODO Auto-generated method stub
			System.out.println("추가할 상품명을 입력해주세요.");
			
		}
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Ex5AnnonyInterface anno=new Ex5AnnonyInterface();
		anno.company.listSangpum();
		anno.company.deleteSangpum();
		anno.company.addSangpum();

	}

}
