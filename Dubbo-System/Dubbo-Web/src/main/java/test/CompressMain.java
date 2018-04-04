package test;

import com.darly.dubbo.framework.common.CompressUtil;
import org.apache.commons.codec.CharEncoding;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Author : ZhangYuHui
 * Date : 2018/2/28
 * TODO :
 */
public class CompressMain {
    public static void main(String[] args){
//        String arsg= "山东打飞机哦我而惊世毒妃 阿斯蒂芬大师傅意识到今年；减肥胶囊s.ek9次呢";
//        try {
//            String resutl = CompressUtil.compreser(arsg.getBytes("UTF-8"));
//            System.out.println(resutl);
//            String ars = CompressUtil.uncompreser(resutl,"UTF-8");
//            System.out.println(ars);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        Map<String ,String> map  = new HashMap<>();
        map.put("KeyWord","太阳");
//        map.put("way","1");
        String json = HttpClientHelper.sendPost("http://localhost:8082/dubbo/search",map, CharEncoding.ISO_8859_1);
        System.out.println(json.getBytes().length);
        System.out.println(json);
        try {
            String un = CompressUtil.uncompreser(json,"UTF-8");
            System.out.println(un.getBytes().length);
            System.out.println(un);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


//        String test = "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ";
//        for (char t: test.toCharArray()) {
//            System.out.print(Integer.toBinaryString(t)+ " ");
//        }
//        System.out.println();
//        String  comp = CompressUtil.compactString(test);
//        for (char t: comp.toCharArray()) {
//            System.out.print(Integer.toBinaryString(t)+ " ");
//        }
//        System.out.println();
//
//
//        String key = CompressUtil.decompressionString(comp);
//        for (char t: key.toCharArray()) {
//            System.out.print(Integer.toBinaryString(t)+ " ");
//        }
//        System.out.println();
//        System.out.println(comp.getBytes().length+"--->"+comp);
//        System.out.println(key.getBytes().length+"--->"+key);
        //lucene中使用的压缩方案，调用过程中，发现效果不佳
//        String resuls = "{\"result\":[{\"lucenekey\":\"太阳\",\"id\":\"180131204759628bba13fc4e621aa7a8\"},{\"lucenekey\":\"太阳\",\"id\":\"1801312117286065aa692980f4cce412\"},{\"lucenekey\":\"太阳\",\"id\":\"180131210639006e944fcf3850f64777\"},{\"lucenekey\":\"太阳\",\"id\":\"1801312104514281bcfe6557d5f70cfc\"},{\"lucenekey\":\"太阳\",\"id\":\"1801312059507117b76f55e129cd4f07\"},{\"lucenekey\":\"太阳\",\"id\":\"180131210159906fa2b90ab21164d5c0\"},{\"lucenekey\":\"太阳\",\"id\":\"18013120405085149355c3d0d11521dc\"},{\"lucenekey\":\"太阳\",\"id\":\"1801312148216521b2f437fab191ba4f\"},{\"lucenekey\":\"太阳\",\"id\":\"180131203035368d9ca13e7b1f21f81a\"},{\"lucenekey\":\"太阳\",\"id\":\"18013119071064299f47f320ef85270c\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311934221679bfe9523e7b8aadd5\"},{\"lucenekey\":\"太阳\",\"id\":\"180131203718179b80a0dbbc059548e1\"},{\"lucenekey\":\"太阳\",\"id\":\"180131201505432f93b890edbeaa1ccf\"},{\"lucenekey\":\"太阳\",\"id\":\"180131205615608c85f82220e9335497\"},{\"lucenekey\":\"太阳\",\"id\":\"180131204921948e8a6d374e25c8c50f\"},{\"lucenekey\":\"太阳\",\"id\":\"1801312011083218ac3a6b3709966a54\"},{\"lucenekey\":\"太阳\",\"id\":\"180131202625666fa29fa4f808ef0937\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311953178449b55a2136d78aec32\"},{\"lucenekey\":\"太阳\",\"id\":\"180131191246875d801e077d73c532c9\"},{\"lucenekey\":\"太阳\",\"id\":\"180131200651183b88201f09a02fa413\"},{\"lucenekey\":\"太阳\",\"id\":\"18013119400119139ad723a95bd04054\"},{\"lucenekey\":\"太阳\",\"id\":\"180131192628377cba5708f276d49980\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311829245844a762021e0b88bed8\"},{\"lucenekey\":\"太阳\",\"id\":\"180131180402478e9cd48cb46fb86595\"},{\"lucenekey\":\"太阳\",\"id\":\"18013118060639198d889361c79df69f\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311540315811a765090f2fbda6aa\"},{\"lucenekey\":\"太阳\",\"id\":\"180131153903173398032fe7b945fbad\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311543386192bc7fc62b197f0538\"},{\"lucenekey\":\"太阳\",\"id\":\"18013115420501538e7fedfb5bfb7835\"},{\"lucenekey\":\"太阳\",\"id\":\"180131154121835fa322d8db236c46c4\"},{\"lucenekey\":\"太阳\",\"id\":\"18013115502137419005cff06fb6ba2d\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311549207910b0b03912bb90dbd7\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311525214972924be3ce20ac4e57\"},{\"lucenekey\":\"太阳\",\"id\":\"180131140331059baf5f11cf11ea9a72\"},{\"lucenekey\":\"太阳\",\"id\":\"180131140208962792d048762736d8d5\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311444032622b389fc0c6072ddb2\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311442423215bb97d31477fde4d7\"},{\"lucenekey\":\"太阳\",\"id\":\"18013114411906468b99e1c25975f089\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311439553096bbdcb1aac6d33b5a\"},{\"lucenekey\":\"太阳\",\"id\":\"180131143840259eb55512df02148f60\"},{\"lucenekey\":\"太阳\",\"id\":\"180131144706714aa5ec1aef1a29c5e3\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311445242911bd99fa4b94c7c02c\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311506538035ae9edf7e8fb90e84\"},{\"lucenekey\":\"太阳\",\"id\":\"18013115052498729e64e6a568177f49\"},{\"lucenekey\":\"太阳\",\"id\":\"180131144921305a9c2e071e81a5a63f\"},{\"lucenekey\":\"太阳\",\"id\":\"18013114491585279dbc85d329b614b0\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311447530890b289f41b30f59586\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311456546246b5f596dc0d118072\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311523260439be180fa57dd22cff\"},{\"lucenekey\":\"太阳\",\"id\":\"180131152035785b8d97ce3361c32823\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311512449149b29c7e374005ec25\"},{\"lucenekey\":\"太阳\",\"id\":\"180131151203068790c1a13aeb607d77\"},{\"lucenekey\":\"太阳\",\"id\":\"180131151144268db8a61b9518be2c60\"},{\"lucenekey\":\"太阳\",\"id\":\"18013111361223489fdf555238a8723c\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311134423472bed6565db797dc6e\"},{\"lucenekey\":\"太阳\",\"id\":\"180131113316200484bc82fe65ea6bb3\"},{\"lucenekey\":\"太阳\",\"id\":\"180131111322655b877e10c149c3264a\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311112277089837cb2a0b24f1e80\"},{\"lucenekey\":\"太阳\",\"id\":\"180131111008339c96054b64986bcdb1\"},{\"lucenekey\":\"太阳\",\"id\":\"180131110827235ea24e9e48e3f57a10\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311132185774aef836e1f93b66e2\"},{\"lucenekey\":\"太阳\",\"id\":\"180131112858565782a2ecd44d81322e\"},{\"lucenekey\":\"太阳\",\"id\":\"18013111264742749891ef3585f150ad\"},{\"lucenekey\":\"太阳\",\"id\":\"180131110657484b8c124b4df9591ffe\"},{\"lucenekey\":\"太阳\",\"id\":\"180131112222717c9da02586d1f186a9\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311126078988a0450b91c8767eab\"},{\"lucenekey\":\"太阳\",\"id\":\"180131112337849aab9bd3cb909246d5\"},{\"lucenekey\":\"太阳\",\"id\":\"180131112239598ebd2294a9edefb533\"},{\"lucenekey\":\"太阳\",\"id\":\"180131103426485ab8388160a95c7dcd\"},{\"lucenekey\":\"太阳\",\"id\":\"180131103408145d9b4873d23c77c653\"},{\"lucenekey\":\"太阳\",\"id\":\"180131103349962ebaa256b40e64be8b\"},{\"lucenekey\":\"太阳\",\"id\":\"18013110352836629efac642ecdd37d5\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311042043420aba98742d45e0ee7\"},{\"lucenekey\":\"太阳\",\"id\":\"18013111003841298780b6fe18cd1b21\"},{\"lucenekey\":\"太阳\",\"id\":\"180131105920783f9d716719b966a534\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311026064984aefd8136852993c0\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311025227644881c36a929973078\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311031173743b365e92019eb25cc\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311057280870a07dc85ea90d7539\"},{\"lucenekey\":\"太阳\",\"id\":\"180131105643285990d9ab3c26539676\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311028082291babe8a8702d02a0a\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311027425589949ce7bc2d0fd698\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311357188551afa10b88506d7dd3\"},{\"lucenekey\":\"太阳\",\"id\":\"180131135614870cb6ee062352f00a2a\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311354588370a9a84b117376fc0a\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311349510410a069d6c6117afa77\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311348129531ba9556967516e710\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311347120044b479b3ec593d5780\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311408428083af8bfda0336e62b0\"},{\"lucenekey\":\"太阳\",\"id\":\"180131140052385584cadf615335757c\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311431000875bc859e6ee36c35cd\"},{\"lucenekey\":\"太阳\",\"id\":\"180131142838310e8170aaf84883a383\"},{\"lucenekey\":\"太阳\",\"id\":\"180131142723893085c811daef15ebf6\"},{\"lucenekey\":\"太阳\",\"id\":\"180131131400432ebd0b5b1da3ffc0e4\"},{\"lucenekey\":\"太阳\",\"id\":\"180131131207675e8644049a134810b3\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311251174465af10031d84655b64\"},{\"lucenekey\":\"太阳\",\"id\":\"180131122838221c8b5f9f593403a54e\"},{\"lucenekey\":\"太阳\",\"id\":\"18013112280111649f72dd4e959ce9d7\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311227270282b733b49b607f44a0\"},{\"lucenekey\":\"太阳\",\"id\":\"180131130958979882dbb8f91dd3bf70\"},{\"lucenekey\":\"太阳\",\"id\":\"180131122550122d8d8da898cc34f632\"},{\"lucenekey\":\"太阳\",\"id\":\"180131123221790ea89a7217c73357f6\"},{\"lucenekey\":\"太阳\",\"id\":\"180131160700547682123ebee6d28e76\"},{\"lucenekey\":\"太阳\",\"id\":\"180131160531363b820c88caefa1b31d\"},{\"lucenekey\":\"太阳\",\"id\":\"180131161027359b9dcbf7012c11cd95\"},{\"lucenekey\":\"太阳\",\"id\":\"180131161001909ab9391e595951c5f6\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311609099967af64caebb9fa9e4a\"},{\"lucenekey\":\"太阳\",\"id\":\"180131160904115a8fd29a324f1d1c28\"},{\"lucenekey\":\"太阳\",\"id\":\"18013116350715279ecff4d3b65ee308\"},{\"lucenekey\":\"太阳\",\"id\":\"18013116322469108b60dde104c8f4a0\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311602523529a14a2094cbec1691\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311602458157ac0c200cc27ecb30\"},{\"lucenekey\":\"太阳\",\"id\":\"180131160234393f92283b979699cfbf\"},{\"lucenekey\":\"太阳\",\"id\":\"18013116113601538c3cf6221d4c8b2a\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311619304172bdd1ce8b4b2b17b2\"},{\"lucenekey\":\"太阳\",\"id\":\"180131163144055889fecebcedc7887e\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311706209276b9222c44dfa9d4c7\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311647117684a9abeb81ec33730a\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311641200480a6876863668ca6d1\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311640186863b249691cb5a54ccc\"},{\"lucenekey\":\"太阳\",\"id\":\"180131170430228f9522b4c4a2ef39fd\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311644360584a3f9ccd53f13f74a\"},{\"lucenekey\":\"太阳\",\"id\":\"18013116595282718d628adf15de72ba\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311710260390aade5dd2d4b93f88\"},{\"lucenekey\":\"太阳\",\"id\":\"18013116501987359195e0d31a2b93a6\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311650141230b5f265b080d5d5d7\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311638006399a46aa8d66e958daa\"},{\"lucenekey\":\"太阳\",\"id\":\"180131163610825aaaf4ca57411cbae2\"},{\"lucenekey\":\"太阳\",\"id\":\"180131173839635787ffa694eba083d9\"},{\"lucenekey\":\"太阳\",\"id\":\"18013117332158769e4ae28d2a97d632\"},{\"lucenekey\":\"太阳\",\"id\":\"180131175416372c9c79f841c8c3e317\"},{\"lucenekey\":\"太阳\",\"id\":\"180131174743747b9eacb5cda14fd5e6\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311853259609b39163b664f05ad3\"},{\"lucenekey\":\"太阳\",\"id\":\"180131185243068c9b2d2b49a827984c\"},{\"lucenekey\":\"太阳\",\"id\":\"180131184147650b9d124eedc18100a1\"},{\"lucenekey\":\"太阳\",\"id\":\"180131183743308b84e86a9501e53823\"},{\"lucenekey\":\"太阳\",\"id\":\"180131184939181a88cacbc2f841d42f\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311208511883aa27dfabb224f7c6\"},{\"lucenekey\":\"太阳\",\"id\":\"180131120838796ea63c9b30675af788\"},{\"lucenekey\":\"太阳\",\"id\":\"180131120838137caf98d14c094ae3c1\"},{\"lucenekey\":\"太阳\",\"id\":\"180131120746923a8283b654b0e53fc9\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311206590830ac81caf1c14583c3\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311222369987b1aec8b69ad26a30\"},{\"lucenekey\":\"太阳\",\"id\":\"180131120120441dbc7a84dc45876a74\"},{\"lucenekey\":\"太阳\",\"id\":\"180131120053104f9d3b9098354d402e\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311158485049b0a6d336d43edfe5\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311211191650b6cff30faeae726d\"},{\"lucenekey\":\"太阳\",\"id\":\"180131121059229aa03f0beb21d7fecc\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311209596479bf7248f2c438ae3b\"},{\"lucenekey\":\"太阳\",\"id\":\"180131114525167082c5b28aa44af9eb\"},{\"lucenekey\":\"太阳\",\"id\":\"180131113740356c92ddf7b8bc56657a\"},{\"lucenekey\":\"太阳\",\"id\":\"1801311104393502bbaf4fa2a4bcaec9\"},{\"lucenekey\":\"太阳\",\"id\":\"180131110415955a82a6754c16e65294\"},{\"lucenekey\":\"太阳\",\"id\":\"180131110333219aa8996bfd0d30ac2f\"},{\"lucenekey\":\"阳\",\"id\":\"1801311217426487b8392e2d24dc2712\"},{\"lucenekey\":\"阳\",\"id\":\"18013116554011329620177838581aba\"},{\"lucenekey\":\"阳\",\"id\":\"180131121302116db0c9dc2d49bdec0f\"}],\"resDesc\":\"測試正常\",\"resCode\":\"200\"}";
//        try {
//            byte[] res = resuls.getBytes("UTF-8");
//            byte[] bytes = new byte[1024*5];
//            ByteArrayDataOutput output = new ByteArrayDataOutput(bytes);
//            ByteArrayDataInput input = new ByteArrayDataInput(bytes);
//            BytesRef ref = new BytesRef();
//            Compressor compressor = CompressionMode.FAST.newCompressor();
//            compressor.compress(res,0,res.length,output);
//            System.out.println(bytes.length+"---->"+Bytes.asList(bytes));
//            Decompressor decompressor = CompressionMode.FAST.newDecompressor();
//            decompressor.decompress(input,bytes.length,0,output.getPosition(),ref);
//            System.out.println(ref.length+"---->"+ref.utf8ToString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }


}
