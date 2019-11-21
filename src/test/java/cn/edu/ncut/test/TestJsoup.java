package cn.edu.ncut.test;

import cn.edu.ncut.common.util.FileUtils;
import cn.edu.ncut.model.RankObj;
import net.sf.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestJsoup extends Thread {

    public void run() {
        List<RankObj> rankObjList= null;
        for (int a = 0; a < 50; a++) {
            try {
                Thread.sleep(5000);
                // rankObjList = anlysisHTMLByURL();
                 rankObjList = anlysisWordHTMLByURL();


            } catch (Exception e) {
            }

            StringBuilder sb =new StringBuilder();
            for (int i = 0; i < rankObjList.size(); i++) {
                String per = rankObjList.get(i).getRank() + "  " + rankObjList.get(i).getName() + "  " + rankObjList.get(i).getRankIndex();
                sb.append(per);
                sb.append("\r\n");
            }
            //准备文件名
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH mm ss");//设置日期格式
            String format = df.format(new Date());
            System.out.println(format);// new Date()为获取当前系统时间
            //写入
            FileUtils.writeStringToFile("src/"+format+".txt",sb.toString());

        }
    }


    public static void main(String[] args) {
        TestJsoup t1 = new TestJsoup();
        t1.start();
    }

//    @Test
    public void saveAuthor() throws IOException {
        List<RankObj> rankObjList = anlysisHTMLByURL();
        for (int i = 0; i < rankObjList.size(); i++) {
            String per = rankObjList.get(i).getRank() + "  " + rankObjList.get(i).getName() + "  " + rankObjList.get(i).getRankIndex();
            //System.out.println(per);

        }
    }


    // 获取热搜名字
    public List<RankObj> anlysisHTMLByURL() throws IOException {
        int timeout = 3000;
        Document doc = Jsoup.connect("http://s.weibo.com/top/summary?cate=total&key=person").get();
        Elements select = doc.select("script");
        Element tds = select.get(select.size() - 2);
        String str = tds.toString();
        str = str.substring(49, str.length() - 10);
        // System.out.println(str);

        // 解析json
        JSONObject dataJson = JSONObject.fromString(str);
        String html = dataJson.getString("html");
        //.out.println(html);

        // 抽取table中的内容
        List<RankObj> rankObjList = new ArrayList<>();
        Document htmlDoc = Jsoup.parse(html);
        Elements trs = htmlDoc.select("table").select("tr");
        dealRankObj(rankObjList, trs);

        return rankObjList;
    }

    private void dealRankObj(List<RankObj> rankObjList, Elements trs) {
        for (int i = 1; i < trs.size(); i++) {
            Elements htmltds = trs.get(i).select("td");
            RankObj rankObj = new RankObj();
            for (int j = 0; j < htmltds.size(); j++) {
                // String text = htmltds.get(j).text();
                // 放一行
                if (j == 0) {
                    rankObj.setRank(Integer.parseInt(htmltds.get(j).text()));
                } else if (j == 1) {
                    rankObj.setName(htmltds.get(j).text());
                } else if (j == 2) {
                    rankObj.setRankIndex(Integer.parseInt(htmltds.get(j).text()));
                }
            }
            rankObjList.add(rankObj);
            rankObj = null;
        }
    }

    // 获取热搜词
    public List<RankObj> anlysisWordHTMLByURL() throws IOException {
        int timeout = 3000;
        Document doc = Jsoup.connect("http://s.weibo.com/top/summary?cate=total&key=films").get();

        // 获取script中部分
        Elements select = doc.select("script");
        Element tds = select.get(select.size() - 2);
        String str = tds.toString();
        str = str.substring(49, str.length() - 10);
        // System.out.println(str);

        // 解析json
        JSONObject dataJson = JSONObject.fromString(str);
        String html = dataJson.getString("html");
        // System.out.println(html);

        // 抽取table中的内容
        List<RankObj> rankObjList = new ArrayList<>();
        Document htmlDoc = Jsoup.parse(html);
        Elements trs = htmlDoc.select("table").select("tr");
        dealRankObj(rankObjList, trs);
        return rankObjList;
    }

}
