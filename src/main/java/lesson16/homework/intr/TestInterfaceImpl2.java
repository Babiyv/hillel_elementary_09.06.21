package lesson16.homework.intr;

// 2. Создать 2 класса, каждый из которых будет имплементировать по 2 различных интерфейса(из 4х созданных ранее);
// 2 из 2:
public class TestInterfaceImpl2 implements TestInterface3, TestInterface4{
    @Override
    public void sameDefaultMethod() {
        System.out.println("sameDefaultMethod implementation in TestInterfaceImpl2");;
    }

    @Override
    public void firstContractMethodFromTestInterface3() {
        System.out.println("firstContractMethodFromTestInterface3 implementation in TestInterfaceImpl2");
    }

    @Override
    public void secondContractMethodFromTestInterface3() {
        System.out.println("secondContractMethodFromTestInterface3 implementation in TestInterfaceImpl2");
    }

    @Override
    public void firstContractMethodFromTestInterface4() {
        System.out.println("firstContractMethodFromTestInterface4 implementation in TestInterfaceImpl2");
    }

    @Override
    public void secondContractMethodFromTestInterface4() {
        System.out.println("secondContractMethodFromTestInterface4 implementation in TestInterfaceImpl2");
    }
}
