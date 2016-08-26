package com.ethanco.myrxjavapoboletrictest;

import com.ethanco.myrxjavapoboletrictest.model.Repo;
import com.ethanco.myrxjavapoboletrictest.model.my.CmdRequest;
import com.ethanco.myrxjavapoboletrictest.model.my.TimeResponse;
import com.ethanco.myrxjavapoboletrictest.net.APIService;
import com.ethanco.myrxjavapoboletrictest.net.APIServiceMy;
import com.ethanco.myrxjavapoboletrictest.net.RetrofitFactory;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.httpclient.FakeHttp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import retrofit2.Response;
import rx.Observable;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

/**
 * Created by EthanCo on 2016/8/25.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class ApiTest {

    private APIService apiService;
    private APIServiceMy apiServiceMy;

    @Before
    public void setUp() {
        apiService = RetrofitFactory.getInstance().createRetrofit("https://api.github.com").create(APIService.class);
        apiServiceMy = RetrofitFactory.getInstance().createRetrofit("http://121.40.227.8:8088/").create(APIServiceMy.class);
    }

    @Test
    public void reposTest1() throws IOException {

        String mockJsonResult =
                "[{\"id\":19669199,\"name\":\"AnimationDemo\",\"full_name\":\"DevinShine/AnimationDemo\",\"owner\":{\"login\":\"DevinShine\",\"id\":7385819,\"avatar_url\":\"https://avatars.githubusercontent.com/u/7385819?v=3\",\"gravatar_id\":\"\",\"url\":\"https://api.github.com/users/DevinShine\",\"html_url\":\"https://github.com/DevinShine\",\"followers_url\":\"https://api.github.com/users/DevinShine/followers\",\"following_url\":\"https://api.github.com/users/DevinShine/following{/other_user}\",\"gists_url\":\"https://api.github.com/users/DevinShine/gists{/gist_id}\",\"starred_url\":\"https://api.github.com/users/DevinShine/starred{/owner}{/repo}\",\"subscriptions_url\":\"https://api.github.com/users/DevinShine/subscriptions\",\"organizations_url\":\"https://api.github.com/users/DevinShine/orgs\",\"repos_url\":\"https://api.github.com/users/DevinShine/repos\",\"events_url\":\"https://api.github.com/users/DevinShine/events{/privacy}\",\"received_events_url\":\"https://api.github.com/users/DevinShine/received_events\",\"type\":\"User\",\"site_admin\":false},\"private\":false,\"html_url\":\"https://github.com/DevinShine/AnimationDemo\",\"description\":\"\",\"fork\":false,\"url\":\"https://api.github.com/repos/DevinShine/AnimationDemo\",\"forks_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/forks\",\"keys_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/keys{/key_id}\",\"collaborators_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/collaborators{/collaborator}\",\"teams_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/teams\",\"hooks_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/hooks\",\"issue_events_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/issues/events{/number}\",\"events_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/events\",\"assignees_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/assignees{/user}\",\"branches_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/branches{/branch}\",\"tags_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/tags\",\"blobs_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/git/blobs{/sha}\",\"git_tags_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/git/tags{/sha}\",\"git_refs_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/git/refs{/sha}\",\"trees_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/git/trees{/sha}\",\"statuses_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/statuses/{sha}\",\"languages_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/languages\",\"stargazers_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/stargazers\",\"contributors_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/contributors\",\"subscribers_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/subscribers\",\"subscription_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/subscription\",\"commits_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/commits{/sha}\",\"git_commits_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/git/commits{/sha}\",\"comments_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/comments{/number}\",\"issue_comment_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/issues/comments{/number}\",\"contents_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/contents/{+path}\",\"compare_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/compare/{base}...{head}\",\"merges_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/merges\",\"archive_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/{archive_format}{/ref}\",\"downloads_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/downloads\",\"issues_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/issues{/number}\",\"pulls_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/pulls{/number}\",\"milestones_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/milestones{/number}\",\"notifications_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/notifications{?since,all,participating}\",\"labels_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/labels{/name}\",\"releases_url\":\"https://api.github.com/repos/DevinShine/AnimationDemo/releases{/id}\",\"created_at\":\"2014-05-11T15:05:26Z\",\"updated_at\":\"2014-05-11T15:16:59Z\",\"pushed_at\":\"2014-05-11T15:16:58Z\",\"git_url\":\"git://github.com/DevinShine/AnimationDemo.git\",\"ssh_url\":\"git@github.com:DevinShine/AnimationDemo.git\",\"clone_url\":\"https://github.com/DevinShine/AnimationDemo.git\",\"svn_url\":\"https://github.com/DevinShine/AnimationDemo\",\"homepage\":null,\"size\":1556,\"stargazers_count\":0,\"watchers_count\":0,\"language\":\"Java\",\"has_issues\":true,\"has_downloads\":true,\"has_wiki\":true,\"has_pages\":false,\"forks_count\":0,\"mirror_url\":null,\"open_issues_count\":0,\"forks\":0,\"open_issues\":0,\"watchers\":0,\"default_branch\":\"master\"}]";
        FakeHttp.addPendingHttpResponse(200, mockJsonResult);

        HttpGet httpGet = new HttpGet("http://www.baidu.com");
        HttpResponse httpResponse = new DefaultHttpClient().execute(httpGet);
        String result = EntityUtils.toString(httpResponse.getEntity());
        System.out.print(result);
        assertThat(result, is(mockJsonResult));
    }

    @Test
    public void MockServerTest() throws IOException, InterruptedException {
        // 1. 创建服务器
        MockWebServer server = new MockWebServer();

        // 2. 添加预置的响应，响应会按照先进先出的顺序依次返回
        server.enqueue(new MockResponse().setBody("i am ethanco"));
        server.enqueue(new MockResponse().setResponseCode(404).setBody("not found")); //按顺序返回，即如果请求两次，第二次就会返回这个
        server.enqueue(new MockResponse().setResponseCode(503).setBody("hello, world!")); //第三次返回这个

        // 3. 启动服务器
        server.start();

        // 4. 获取请求 url，不能使用普通的 URL，一定要使用 server.url() 返回的 URL，不然没法进入 Mock 服务器
        HttpUrl baseUrl = server.url("/reg1");

        //5.发送请求
        URL url = new URL(baseUrl.url().toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(5000);

        assertEquals(200, conn.getResponseCode());

        InputStream is = conn.getInputStream();
        //把流转化为文本信息  String
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = is.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        String result = bos.toString();
        bos.close();
        is.close();

        System.out.println(result);

        // server.takeRequest() 是一个阻塞操作，直到接收到请求
        RecordedRequest request1 = server.takeRequest();

        //这里可以查看服务器获取的请求信息，可以查看 http 报文头之类的协议信息
        assertEquals("/reg1", request1.getPath());

        server.shutdown();
    }

    //这个是走真实网络返回的数据
    @Test
    public void reposTest2() {
        List<Repo> list = null;
        try {
            list = apiService.listRepos("devinshine").execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(list.size(), is(not(0)));
        System.out.print(list.size());
    }

    @Test
    public void getTime() {
        try {
            Response<TimeResponse> resposne = apiServiceMy.getServerTime(generateServiceTimeCmd()).execute();
            String time = resposne.body().getData().getTime();
            System.out.println("time:" + time);
            assertNotNull(time);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成 获取服务器时间 CmdRequest
     *
     * @return
     */
    public CmdRequest generateServiceTimeCmd() {
        CmdRequest cmd = new CmdRequest();
        cmd.setCmd("GetServerTime");
        return cmd;
    }

    //Test3 这个是走真实网络返回的数据
    @Test
    public void reposTestByObservable() {
        int size = apiService.listRepos2Observable("devinshine")
                .flatMap(Observable::from)
                .count()
                .toBlocking()
                .single();
        assertThat(size, is(not(0)));
        System.out.print(size);

        //下面代码是会报错的
        //TestSubscriber<Repo> testSubscriber = new TestSubscriber<>();
        //mGithub.listRepos2Observable("devinshine")
        //    .flatMap(Observable::from)
        //    .subscribe(testSubscriber);
        //assertThat(testSubscriber.getOnNextEvents().size(),is(not(0)));
    }

    @Test
    public void reposTestByMockClient() throws IOException {

        /*TimeResponse timeResponse = new TimeResponse();
        timeResponse.setCmd("getTime");
        timeResponse.setResult("Success");
        TimeResponse.Entity entity = new TimeResponse.Entity();
        entity.setTime("20160824");
        entity.setMessage("hello~");
        timeResponse.setData(entity);

        //Response<TimeResponse> response = mock(Response.class);
        Call<TimeResponse> call = mock(Call.class);
        when(apiServiceMy.getServerTime(any())).thenReturn(call);
        when(call.execute()).thenReturn();
        //when(response.body()).thenReturn(timeResponse);

        String time = apiServiceMy.getServerTime(new CmdRequest()).execute().body().getData().getTime();

        System.out.println(time);
        assertThat(time, is("20160824"));*/
    }
}
