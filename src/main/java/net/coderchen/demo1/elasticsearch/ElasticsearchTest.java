package net.coderchen.demo1.elasticsearch;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Liuyuchen on 2018/05/30.
 */
public class ElasticsearchTest {
    public static void main(String[] args) {
        try(TransportClient transportClient = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9200))) {
            SearchResponse searchResponse = transportClient.prepareSearch("website").setTypes("blog").get();
            System.out.println(searchResponse.toString());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
