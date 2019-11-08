package com.设计模式.适配器模式.List;

import java.util.Iterator;
//适配器
public class BookAdapter extends Book implements Iterable<String>{
	@Override
	public Iterator<String> iterator() {
		return new IteratorAdapter(getEnum());
	}
}
