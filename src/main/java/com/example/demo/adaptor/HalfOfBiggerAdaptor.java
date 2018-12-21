package com.example.demo.adaptor;

public class HalfOfBiggerAdaptor extends Bigger implements ISmaller{
	private Bigger bigger;
	
	public HalfOfBiggerAdaptor(int biggerSize) {
		super(biggerSize);
	}
	
	public HalfOfBiggerAdaptor(Bigger bigger) {
		this.bigger=bigger;
	}

	public int halfSize(int biggerSize) {
		int smaller=0;
		if(bigger!=null) {
			smaller=bigger.biggersize();
		}
		return smaller/2;
	}

}
