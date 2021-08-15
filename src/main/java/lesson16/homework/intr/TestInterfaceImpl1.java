package lesson16.homework.intr;

// 2. Создать 2 класса, каждый из которых будет имплементировать по 2 различных интерфейса(из 4х созданных ранее);
// 1 из 2:
public class TestInterfaceImpl1 implements TestInterface1, TestInterface2{

    @Override
    public void sameDefaultMethod() {
        System.out.println("sameDefaultMethod implementation in TestInterfaceImpl1");;
    }

    @Override
    public void firstContractMethodFromTestInterface1() {
        System.out.println("firstContractMethodFromTestInterface1 implementation in TestInterfaceImpl1");
    }

    @Override
    public void secondContractMethodFromTestInterface1() {
        System.out.println("secondContractMethodFromTestInterface1 implementation in TestInterfaceImpl1");
    }

    @Override
    public void firstContractMethodFromTestInterface2() {
        System.out.println("firstContractMethodFromTestInterface2 implementation in TestInterfaceImpl1");
    }

    @Override
    public void secondContractMethodFromTestInterface2() {
        System.out.println("secondContractMethodFromTestInterface2 implementation in TestInterfaceImpl1");
    }
}
