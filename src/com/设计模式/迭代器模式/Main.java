package com.设计模式.迭代器模式;

/**
 * 设计了一个迭代器
 * 书橱类，使用迭代器来放书
 * 接口：Aggregate作为一个拥有迭代器的汇聚类，Iterator迭代器接口
 * 实现类：Book作为书的实体类，BookShelf作为书橱实体类实现了汇聚接口，BookShelfIterator作为书橱的迭代器实现了迭代器接口
 * @author wicks
 *
 */
public class Main {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook(new Book("Around the World in 80 Days"));
        bookShelf.appendBook(new Book("Bible"));
        bookShelf.appendBook(new Book("Cinderella"));
        bookShelf.appendBook(new Book("Daddy-Long-Legs"));
        Iterator it = bookShelf.iterator();
        while (it.hasNext()) {
            Book book = (Book)it.next();
            System.out.println(book.getName());
        }
    }
}
