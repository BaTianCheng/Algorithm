package com.设计模式.观察者模式;
//主题
public interface IWeatherService {
	void addClient(Client client);		//添加观察者
	boolean deleteClient(Client client);//删除观察者
	void notifyClients();				//通知
	void updateWeather(WeatherInfo info);//主题内容更新
}
