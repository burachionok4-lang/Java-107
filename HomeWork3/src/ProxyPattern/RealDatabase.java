package ProxyPattern;

  class RealDatabase implements Database {
    @Override
    public void executeQuery(String query){
        System.out.println("Выполняется запрос: " + query);
    };

}
