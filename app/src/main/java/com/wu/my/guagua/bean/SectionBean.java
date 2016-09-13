package com.wu.my.guagua.bean;

import java.util.List;

/**
 * Created by My on 2016/8/10.
 */
public class SectionBean {

    /**
     * status : 0
     * data : [{"title":"第252话","sid":259,"id":2007942,"size":0.48,"counts":8,"iszm":0,
     * "surl":"http://www.tuku.cc/comic/19498/n-1470801122-55057/"},{"title":"第251话","sid":258,
     * "id":2007941,"size":0.18,"counts":6,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1470801122-12669/"},{"title":"第250话","sid":257,"id":2007221,"size":0.72,
     * "counts":8,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1470639181-64191/"},
     * {"title":"第249话","sid":256,"id":2007220,"size":0.88,"counts":8,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1470549003-85897/"},{"title":"第248话","sid":255,"id":2007219,
     * "size":0.48,"counts":8,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1470549003-39730/"},{"title":"第247话","sid":254,"id":2007218,"size":2.04,
     * "counts":17,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1470549062-33299/"},
     * {"title":"第246话","sid":253,"id":2002594,"size":1.1,"counts":10,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1470296702-85426/"},{"title":"第245话","sid":252,"id":2001075,
     * "size":0.64,"counts":8,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1470215222-39291/"},{"title":"第244话","sid":251,"id":2000542,"size":0.72,
     * "counts":8,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1470129602-38299/"},
     * {"title":"第243话","sid":250,"id":1999539,"size":0.56,"counts":8,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1470026582-22985/"},{"title":"第242话","sid":249,"id":1998850,
     * "size":0.64,"counts":8,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1469942582-52580/"},{"title":"第241话","sid":248,"id":1998453,"size":0.56,
     * "counts":8,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1469874661-19954/"},
     * {"title":"第240话","sid":247,"id":1998452,"size":0.45,"counts":15,"iszm":0,
     * "surl":"http://www.tuku.cc/comic/19498/n-1469874661-57780/"},{"title":"第239话","sid":246,
     * "id":1996803,"size":0.64,"counts":8,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1469681702-44173/"},{"title":"第238话","sid":245,"id":1996802,"size":0.63,
     * "counts":9,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1469681702-52437/"},
     * {"title":"第237话","sid":244,"id":1996801,"size":1.12,"counts":8,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1469681702-85431/"},{"title":"第236话","sid":243,"id":1994677,
     * "size":0.64,"counts":8,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1469466662-92673/"},{"title":"第235话","sid":242,"id":1993854,"size":0.8,
     * "counts":8,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1469355184-44967/"},
     * {"title":"第234话","sid":241,"id":1993195,"size":0.8,"counts":8,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1469273882-94628/"},{"title":"第233话","sid":240,"id":1993194,
     * "size":0.8,"counts":16,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1469273882-13021/"},{"title":"第232话","sid":239,"id":1991946,"size":0.24,
     * "counts":8,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1469118962-31867/"},
     * {"title":"第231话","sid":238,"id":1991945,"size":0.64,"counts":8,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1469118962-85837/"},{"title":"第230话","sid":237,"id":1989802,
     * "size":0.56,"counts":8,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1468908302-10994/"},{"title":"第229话","sid":236,"id":1989049,"size":0.7,
     * "counts":7,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1468816502-17123/"},
     * {"title":"第228话","sid":235,"id":1989048,"size":0.49,"counts":7,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1468816502-42556/"},{"title":"第227话","sid":234,"id":1988018,
     * "size":0.48,"counts":8,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1468660982-96823/"},{"title":"第226话","sid":233,"id":1988017,"size":2.72,
     * "counts":17,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1468660982-18922/"},
     * {"title":"第225话","sid":232,"id":1988016,"size":0.96,"counts":8,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1468660982-13370/"},{"title":"第224话","sid":231,"id":1983970,
     * "size":0.8,"counts":8,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1468382521-43348/"},{"title":"第223话","sid":230,"id":1983603,"size":0.8,
     * "counts":8,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1468296303-55582/"},
     * {"title":"第222话","sid":229,"id":1983092,"size":0.91,"counts":7,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1468228742-51499/"},{"title":"第221话","sid":228,"id":1982522,
     * "size":0.72,"counts":8,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1468132502-82087/"},{"title":"第220话","sid":227,"id":1982079,"size":0.8,
     * "counts":8,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1468049582-76365/"},
     * {"title":"第219话","sid":226,"id":1982078,"size":3.74,"counts":22,"iszm":0,
     * "surl":"http://www.tuku.cc/comic/19498/n-1468049582-83137/"},{"title":"第218话","sid":225,
     * "id":1980736,"size":0.8,"counts":8,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1467868502-85822/"},{"title":"第217话","sid":224,"id":1979521,"size":0.63,
     * "counts":7,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1467782404-50919/"},
     * {"title":"第216话","sid":223,"id":1979520,"size":0.63,"counts":7,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1467782404-33766/"},{"title":"第215话","sid":222,"id":1977617,
     * "size":0.42,"counts":7,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1467606602-37575/"},{"title":"第214话","sid":221,"id":1976510,"size":0.72,
     * "counts":8,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1467522242-92726/"},
     * {"title":"第213话","sid":220,"id":1976509,"size":0.64,"counts":8,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1467522242-20498/"},{"title":"第212话","sid":219,"id":1976508,
     * "size":1.87,"counts":17,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1467522242-44895/"},{"title":"第211话","sid":218,"id":1972096,"size":0.88,
     * "counts":8,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1467261182-64139/"},
     * {"title":"第210话","sid":217,"id":1970920,"size":0.35,"counts":7,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1467175801-76281/"},{"title":"第209话","sid":216,"id":1970740,
     * "size":0.48,"counts":8,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1467135604-25887/"},{"title":"第208话","sid":215,"id":1970739,"size":0.3,
     * "counts":10,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1467135604-30351/"},
     * {"title":"第207话","sid":214,"id":1966007,"size":0.56,"counts":8,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1466919122-61246/"},{"title":"第206话","sid":213,"id":1966006,
     * "size":0.49,"counts":7,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1466919122-26048/"},{"title":"第205话","sid":212,"id":1966005,"size":1.61,
     * "counts":23,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1466919122-86301/"},
     * {"title":"第204话","sid":211,"id":1961820,"size":0.8,"counts":8,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1466661182-41889/"},{"title":"第203话","sid":210,"id":1960891,
     * "size":0.8,"counts":8,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1466573942-80498/"},{"title":"第202话","sid":209,"id":1960111,"size":0.8,
     * "counts":10,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1466479682-42344/"},
     * {"title":"第201话","sid":208,"id":1958335,"size":0.45,"counts":9,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1466399101-35818/"},{"title":"第200话","sid":207,"id":1956418,
     * "size":0.7,"counts":7,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1466316422-67099/"},{"title":"第199话","sid":206,"id":1953919,"size":0.99,
     * "counts":9,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1466226602-72628/"},
     * {"title":"第198话","sid":205,"id":1953881,"size":2.8,"counts":20,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1466134264-63915/"},{"title":"第197话","sid":204,"id":1951001,
     * "size":0.4,"counts":8,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1466048942-86291/"},{"title":"第196话","sid":203,"id":1951000,"size":0.32,
     * "counts":8,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1466048942-56278/"},
     * {"title":"第195话","sid":202,"id":1950999,"size":0.96,"counts":8,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1466048942-86636/"},{"title":"第194话","sid":201,"id":1950998,
     * "size":0.56,"counts":8,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1466048942-56222/"},{"title":"第193话","sid":200,"id":1946601,"size":0.7,
     * "counts":7,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1465702442-32127/"},
     * {"title":"第192话","sid":199,"id":1946600,"size":0.48,"counts":8,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1465702442-44586/"},{"title":"第191话","sid":198,"id":1946599,
     * "size":1.14,"counts":19,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1465702442-57406/"},{"title":"第190话","sid":197,"id":1946598,"size":0.36,
     * "counts":6,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1465702442-67208/"},
     * {"title":"第189话","sid":196,"id":1946597,"size":0.56,"counts":8,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1465702442-56984/"},{"title":"第188话","sid":195,"id":1946596,
     * "size":0.77,"counts":7,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1465702442-16357/"},{"title":"第187话","sid":194,"id":1940297,"size":0.98,
     * "counts":7,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1465185842-34277/"},
     * {"title":"第186话","sid":193,"id":1939534,"size":0.7,"counts":7,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1465108562-17945/"},{"title":"第185话","sid":192,"id":1938531,
     * "size":0.7,"counts":7,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1465018081-51459/"},{"title":"第184话","sid":191,"id":1937795,"size":1.7,
     * "counts":17,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1464929102-22327/"},
     * {"title":"第183话","sid":190,"id":1936904,"size":0.54,"counts":6,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1464843062-95170/"},{"title":"第182话","sid":189,"id":1936903,
     * "size":0.96,"counts":6,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1464843062-80188/"},{"title":"第181话","sid":188,"id":1935129,"size":0.66,
     * "counts":6,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1464671942-57902/"},
     * {"title":"第180话","sid":187,"id":1933975,"size":0.48,"counts":6,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1464583922-53476/"},{"title":"第179话","sid":186,"id":1932821,
     * "size":0.84,"counts":6,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1464498483-19150/"},{"title":"第178话","sid":185,"id":1932820,"size":0.66,
     * "counts":6,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1464498483-66962/"},
     * {"title":"第177话","sid":184,"id":1932819,"size":0.96,"counts":12,"iszm":0,
     * "surl":"http://www.tuku.cc/comic/19498/n-1464498483-64828/"},{"title":"第176话","sid":183,
     * "id":1932818,"size":0.54,"counts":6,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1464498483-36797/"},{"title":"第175话","sid":182,"id":1932817,"size":0.42,
     * "counts":6,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1464498483-30079/"},
     * {"title":"第174话","sid":181,"id":1932816,"size":0.48,"counts":6,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1464498483-50890/"},{"title":"第173话","sid":180,"id":1932815,
     * "size":0.66,"counts":6,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1464498483-72399/"},{"title":"第172话","sid":179,"id":1932814,"size":1.02,
     * "counts":6,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1464498483-22659/"},
     * {"title":"第171话","sid":178,"id":1932813,"size":0.72,"counts":6,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1464498483-80886/"},{"title":"第170话","sid":177,"id":1932812,
     * "size":1.54,"counts":14,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1464498483-22578/"},{"title":"第169话","sid":176,"id":1932811,"size":0.7,
     * "counts":5,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1464498483-51360/"},
     * {"title":"第168话","sid":175,"id":1932810,"size":0.65,"counts":5,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1464498483-87304/"},{"title":"第167话","sid":174,"id":1932809,
     * "size":0.48,"counts":6,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1464498483-68071/"},{"title":"第166话","sid":173,"id":1932808,"size":0.78,
     * "counts":6,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1464498483-83322/"},
     * {"title":"第165话","sid":172,"id":1932807,"size":0.7,"counts":7,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1464498483-94117/"},{"title":"第164话","sid":171,"id":1932806,
     * "size":0.7,"counts":5,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1464498483-83289/"},{"title":"第163话","sid":170,"id":1932805,"size":0.9,
     * "counts":9,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1464498483-78463/"},
     * {"title":"第162话","sid":169,"id":1932804,"size":0.9,"counts":6,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1464498483-63095/"},{"title":"第161话","sid":168,"id":1932803,
     * "size":0.6,"counts":6,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1464498482-58113/"},{"title":"第160话","sid":167,"id":1932802,"size":0.48,
     * "counts":6,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1464498482-34283/"},
     * {"title":"第159话","sid":166,"id":1932801,"size":0.7,"counts":5,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1464498482-72249/"},{"title":"第158话","sid":165,"id":1932800,
     * "size":0.76,"counts":4,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1464498482-96240/"},{"title":"第157话","sid":164,"id":1932799,"size":0.75,
     * "counts":5,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1464498482-36355/"},
     * {"title":"第156话","sid":163,"id":1932798,"size":0.72,"counts":8,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1464498482-24896/"},{"title":"第155话","sid":162,"id":1932797,
     * "size":0.91,"counts":7,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1464498482-82688/"},{"title":"第154话","sid":161,"id":1932796,"size":0.55,
     * "counts":5,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1464498482-29375/"},
     * {"title":"第153话","sid":160,"id":1932795,"size":0.7,"counts":5,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1464498482-30824/"},{"title":"第152话","sid":159,"id":1932794,
     * "size":0.36,"counts":4,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1464498482-22425/"},{"title":"第151话","sid":158,"id":1932793,"size":0.52,
     * "counts":4,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1464498482-68703/"},
     * {"title":"第150话","sid":157,"id":1932792,"size":0.6,"counts":4,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1464498482-46008/"},{"title":"第149话","sid":156,"id":1932791,
     * "size":2.04,"counts":12,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1464498482-60720/"},{"title":"第148话","sid":155,"id":1932790,"size":0.55,
     * "counts":5,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1464498482-30926/"},
     * {"title":"第147话","sid":154,"id":1932789,"size":0.56,"counts":4,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1464498482-85571/"},{"title":"第146话","sid":153,"id":1932788,
     * "size":0.7,"counts":5,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1464498482-50531/"},{"title":"第145话","sid":152,"id":1932787,"size":0.6,
     * "counts":4,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1464498482-49239/"},
     * {"title":"第144话","sid":151,"id":1932786,"size":0.6,"counts":4,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1464498482-23001/"},{"title":"第143话","sid":150,"id":1932785,
     * "size":0.36,"counts":4,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1464498482-60530/"},{"title":"第142话","sid":149,"id":1932784,"size":0.56,
     * "counts":7,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1464498482-85690/"},
     * {"title":"第141话","sid":148,"id":1932783,"size":0.7,"counts":5,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1464498482-20838/"},{"title":"第140话","sid":147,"id":1932782,
     * "size":0.35,"counts":5,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1464498482-11414/"},{"title":"第139话","sid":146,"id":1932781,"size":0.5,
     * "counts":5,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1464498482-32246/"},
     * {"title":"第138话","sid":145,"id":1932780,"size":0.4,"counts":4,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1464498482-77701/"},{"title":"第137话","sid":144,"id":1932779,
     * "size":0.75,"counts":5,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1464498482-64271/"},{"title":"第136话","sid":143,"id":1932778,"size":0.4,
     * "counts":5,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1464498482-79978/"},
     * {"title":"第135话","sid":142,"id":1932776,"size":1.6,"counts":10,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1464498482-12826/"},{"title":"第134话","sid":141,"id":1932775,
     * "size":0.65,"counts":5,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1464498482-89346/"},{"title":"第133话","sid":140,"id":1932774,"size":0.5,
     * "counts":5,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1464498482-46216/"},
     * {"title":"第132话","sid":139,"id":1932773,"size":0.7,"counts":5,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1464498482-69504/"},{"title":"第131话","sid":138,"id":1932772,
     * "size":0.75,"counts":5,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1464498482-19147/"},{"title":"第130话","sid":137,"id":1932771,"size":0.55,
     * "counts":5,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1464498482-69815/"},
     * {"title":"第129话","sid":136,"id":1932770,"size":0.85,"counts":5,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1464498482-26367/"},{"title":"第128话","sid":135,"id":1932769,
     * "size":0.72,"counts":9,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1464498482-31227/"},{"title":"第127话","sid":134,"id":1932768,"size":0.48,
     * "counts":4,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1464498482-35739/"},
     * {"title":"第126话","sid":133,"id":1932767,"size":0.84,"counts":4,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1464498482-65766/"},{"title":"第125话","sid":132,"id":1932766,
     * "size":0.4,"counts":4,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1464498482-15211/"},{"title":"第124话","sid":131,"id":1932765,"size":0.56,
     * "counts":4,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1464498482-25731/"},
     * {"title":"第123话","sid":130,"id":1932764,"size":0.36,"counts":3,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1464498482-37057/"},{"title":"第122话","sid":129,"id":1932763,
     * "size":0.6,"counts":3,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1464498482-55738/"},{"title":"第121话","sid":128,"id":1932762,"size":0.85,
     * "counts":5,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1464498482-64390/"},
     * {"title":"第120话","sid":127,"id":1932761,"size":0.48,"counts":3,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1464498482-74153/"},{"title":"第119话","sid":126,"id":1932760,
     * "size":0.42,"counts":3,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1464498482-79938/"},{"title":"第118话","sid":125,"id":1932759,"size":0.72,
     * "counts":3,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1464498482-69127/"},
     * {"title":"第117话","sid":124,"id":1932758,"size":0.42,"counts":3,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1464498482-76704/"},{"title":"第116话","sid":123,"id":1932757,
     * "size":0.51,"counts":3,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1464498482-90536/"},{"title":"第115话","sid":122,"id":1932756,"size":0.48,
     * "counts":3,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1464498482-23927/"},
     * {"title":"第114话","sid":121,"id":1932755,"size":0.48,"counts":6,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1464498482-28059/"},{"title":"第113话","sid":120,"id":1932754,
     * "size":0.45,"counts":3,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1464498482-96763/"},{"title":"第112话","sid":119,"id":1932753,"size":0.66,
     * "counts":3,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1464498482-46017/"},
     * {"title":"第111话","sid":118,"id":1932752,"size":0.42,"counts":3,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1464498482-78799/"},{"title":"第110话","sid":117,"id":1932751,
     * "size":0.66,"counts":3,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1464498482-45672/"},{"title":"第109话","sid":116,"id":1932749,"size":0.96,
     * "counts":4,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1464498482-11299/"},
     * {"title":"第108话","sid":115,"id":1932748,"size":1.08,"counts":4,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1464498482-12847/"},{"title":"第107话","sid":114,"id":1932747,
     * "size":1.47,"counts":7,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1464498482-87419/"},{"title":"第106话","sid":113,"id":1932746,"size":1.26,
     * "counts":6,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1464498482-48807/"},
     * {"title":"第105话","sid":112,"id":1932745,"size":0.48,"counts":6,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1464498482-97247/"},{"title":"第104话","sid":111,"id":1932744,
     * "size":0.48,"counts":4,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1464498482-69479/"},{"title":"第103话","sid":110,"id":1932743,"size":0.56,
     * "counts":7,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1464498482-35349/"},
     * {"title":"第102话","sid":109,"id":1932742,"size":0.56,"counts":4,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1464498482-77403/"},{"title":"第101话","sid":108,"id":1932741,
     * "size":0.56,"counts":4,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1464498482-67883/"},{"title":"第100话","sid":107,"id":1932740,"size":0.52,
     * "counts":4,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1464498482-39440/"},
     * {"title":"第99话","sid":106,"id":1932739,"size":0.68,"counts":4,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1464498482-89734/"},{"title":"第98话","sid":105,"id":1932738,"size":0
     * .8,"counts":4,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1464498482-48458/"},
     * {"title":"第97话","sid":104,"id":1932737,"size":0.52,"counts":4,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1464498482-13557/"},{"title":"第96话","sid":103,"id":1932736,"size":0
     * .88,"counts":4,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1464498482-88028/"},
     * {"title":"第95话","sid":102,"id":1932735,"size":0.27,"counts":3,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1464498482-44909/"},{"title":"第94话","sid":101,"id":1932734,"size":0
     * .84,"counts":4,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1464498482-37799/"},
     * {"title":"第93话","sid":100,"id":1932733,"size":0.56,"counts":4,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1464498482-34502/"},{"title":"第92话","sid":99,"id":1932732,"size":0
     * .52,"counts":4,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1464498482-99591/"},
     * {"title":"第91话","sid":98,"id":1932731,"size":0.48,"counts":4,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1464498646-54177/"},{"title":"第90话","sid":97,"id":1932730,"size":0
     * .6,"counts":4,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1464498646-27234/"},
     * {"title":"第89话","sid":96,"id":1932729,"size":0.48,"counts":4,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1464498646-52315/"},{"title":"第88话","sid":95,"id":1932728,"size":0
     * .42,"counts":3,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1464498646-62460/"},
     * {"title":"第87话","sid":94,"id":1932727,"size":0.51,"counts":3,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1464498646-82750/"},{"title":"第86话","sid":93,"id":1932726,"size":1
     * .92,"counts":8,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1464498646-10750/"},
     * {"title":"第85话","sid":92,"id":1932725,"size":0.44,"counts":4,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1464498646-27267/"},{"title":"第84话","sid":91,"id":1932724,"size":0
     * .72,"counts":4,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1464498646-45049/"},
     * {"title":"第83话","sid":90,"id":1932723,"size":0.48,"counts":4,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1464498646-32324/"},{"title":"083","sid":89,"id":1932722,"size":0
     * .72,"counts":4,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1464498646-89334/"},
     * {"title":"第82话","sid":88,"id":1932721,"size":0.32,"counts":4,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1464498646-11712/"},{"title":"082","sid":87,"id":1844338,"size":0
     * .36,"counts":4,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1456202821-23250/"},
     * {"title":"第81话","sid":86,"id":1932720,"size":0.32,"counts":4,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1464498646-11712/"},{"title":"081","sid":85,"id":1843588,"size":0
     * .24,"counts":4,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1456118341-59918/"},
     * {"title":"第80话","sid":84,"id":1932719,"size":0.48,"counts":4,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1464498646-52951/"},{"title":"080","sid":83,"id":1843378,"size":0
     * .48,"counts":4,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1456072922-78775/"},
     * {"title":"第79话","sid":82,"id":1932718,"size":0.56,"counts":4,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1464498646-19886/"},{"title":"079","sid":81,"id":1842966,"size":0
     * .32,"counts":4,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1456028581-75804/"},
     * {"title":"第78话","sid":80,"id":1932717,"size":0.84,"counts":4,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1464498646-80782/"},{"title":"078","sid":79,"id":1841770,"size":0
     * .4,"counts":4,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1455853202-66249/"},
     * {"title":"077","sid":78,"id":1841769,"size":0.6,"counts":4,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1455853202-94348/"},{"title":"076","sid":77,"id":1840522,"size":0
     * .48,"counts":4,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1455681842-51327/"},
     * {"title":"075","sid":76,"id":1840521,"size":0.33,"counts":3,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1455681842-33418/"},{"title":"074","sid":75,"id":1839896,"size":0
     * .4,"counts":4,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1455560282-92267/"},
     * {"title":"073","sid":74,"id":1838504,"size":0.48,"counts":3,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1455426002-53739/"},{"title":"072","sid":73,"id":1838503,"size":0
     * .39,"counts":3,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1455426002-20525/"},
     * {"title":"071","sid":72,"id":1837225,"size":0.64,"counts":4,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1455254642-97983/"},{"title":"070","sid":71,"id":1837224,"size":0
     * .44,"counts":4,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1455254641-89686/"},
     * {"title":"069","sid":70,"id":1836460,"size":0.51,"counts":3,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1455129122-58897/"},{"title":"068","sid":69,"id":1835923,"size":0
     * .44,"counts":4,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1455042782-15656/"},
     * {"title":"067","sid":68,"id":1835079,"size":0.44,"counts":4,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1454908261-77291/"},{"title":"066","sid":67,"id":1835078,"size":0
     * .52,"counts":4,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1454908261-89380/"},
     * {"title":"065","sid":66,"id":1832695,"size":0.42,"counts":3,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1454730061-24401/"},{"title":"064","sid":65,"id":1832694,"size":0
     * .45,"counts":5,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1454730061-28839/"},
     * {"title":"063","sid":64,"id":1831537,"size":0.56,"counts":4,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1454564761-98739/"},{"title":"062","sid":63,"id":1831536,"size":0
     * .44,"counts":4,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1454564761-93019/"},
     * {"title":"061","sid":62,"id":1829874,"size":0.48,"counts":4,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1454390582-22239/"},{"title":"060","sid":61,"id":1829873,"size":0
     * .36,"counts":4,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1454390582-98474/"},
     * {"title":"059","sid":60,"id":1826494,"size":0.48,"counts":4,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1454264101-50704/"},{"title":"058","sid":59,"id":1824727,"size":0
     * .18,"counts":6,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1454136121-10202/"},
     * {"title":"057","sid":58,"id":1824726,"size":0.56,"counts":4,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1454136121-26766/"},{"title":"056","sid":57,"id":1822768,"size":0
     * .36,"counts":4,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1453957862-68570/"},
     * {"title":"055","sid":56,"id":1822767,"size":0.3,"counts":3,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1453957862-13618/"},{"title":"054","sid":55,"id":1821620,"size":0
     * .33,"counts":3,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1453784342-43717/"},
     * {"title":"053","sid":54,"id":1821619,"size":0.4,"counts":4,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1453784342-29758/"},{"title":"052","sid":53,"id":1820776,"size":0
     * .28,"counts":4,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1453684022-55415/"},
     * {"title":"051","sid":52,"id":1819314,"size":0.51,"counts":3,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1453528502-10235/"},{"title":"050","sid":51,"id":1818792,"size":0
     * .48,"counts":3,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1453447262-90928/"},
     * {"title":"049","sid":50,"id":1817780,"size":0.36,"counts":4,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1453395662-72104/"},{"title":"048","sid":49,"id":1815812,"size":0
     * .42,"counts":3,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1453257002-44588/"},
     * {"title":"047","sid":48,"id":1815811,"size":0.33,"counts":3,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1453257002-78753/"},{"title":"046","sid":47,"id":1814672,"size":0
     * .27,"counts":3,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1453146361-52567/"},
     * {"title":"045","sid":46,"id":1813147,"size":0.3,"counts":3,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1453056722-41777/"},{"title":"044","sid":45,"id":1811386,"size":0
     * .36,"counts":3,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1452919081-93674/"},
     * {"title":"043","sid":44,"id":1811385,"size":0.33,"counts":3,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1452919081-53624/"},{"title":"042","sid":43,"id":1809738,"size":0
     * .36,"counts":4,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1452747602-23773/"},
     * {"title":"041","sid":42,"id":1809737,"size":0.22,"counts":2,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1452747602-95228/"},{"title":"040","sid":41,"id":1807702,"size":0
     * .27,"counts":3,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1452575462-22891/"},
     * {"title":"039","sid":40,"id":1806117,"size":0.27,"counts":3,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1452493202-45672/"},{"title":"038","sid":39,"id":1805740,"size":0
     * .48,"counts":3,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1452450542-23371/"},
     * {"title":"037","sid":38,"id":1803576,"size":0.27,"counts":3,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1452312722-17415/"},{"title":"036","sid":37,"id":1802159,"size":0
     * .27,"counts":3,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1452226982-50817/"},
     * {"title":"035","sid":36,"id":1802158,"size":0.56,"counts":4,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1452226982-22699/"},{"title":"034","sid":35,"id":1798736,"size":0
     * .08,"counts":4,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1452052802-66510/"},
     * {"title":"033","sid":34,"id":1797186,"size":0.36,"counts":3,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1451964302-26298/"},{"title":"032","sid":33,"id":1797185,"size":0
     * .3,"counts":3,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1451964302-43400/"},
     * {"title":"031","sid":32,"id":1795787,"size":0.21,"counts":3,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1451845322-94862/"},{"title":"030","sid":31,"id":1795786,"size":0
     * .24,"counts":3,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1451845322-84385/"},
     * {"title":"029","sid":30,"id":1794568,"size":0.33,"counts":3,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1451757482-99165/"},{"title":"028","sid":29,"id":1794567,"size":0
     * .39,"counts":3,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1451757482-55385/"},
     * {"title":"027","sid":28,"id":1793041,"size":0.48,"counts":3,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1451676242-47697/"},{"title":"026","sid":27,"id":1793039,"size":0
     * .27,"counts":3,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1451676242-12593/"},
     * {"title":"025","sid":26,"id":1790942,"size":0.76,"counts":4,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1451539381-72992/"},{"title":"024","sid":25,"id":1790941,"size":0
     * .36,"counts":3,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1451539381-41464/"},
     * {"title":"023","sid":24,"id":1790940,"size":0.21,"counts":3,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1451539381-22011/"},{"title":"022","sid":23,"id":1790939,"size":0
     * .15,"counts":3,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1451539381-78350/"},
     * {"title":"021","sid":22,"id":1788134,"size":0.39,"counts":3,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1451367242-40927/"},{"title":"020","sid":21,"id":1788133,"size":0
     * .3,"counts":3,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1451367242-69009/"},
     * {"title":"019","sid":20,"id":1786861,"size":0.48,"counts":3,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1451278261-93045/"},{"title":"018","sid":19,"id":1786860,"size":0
     * .39,"counts":3,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1451278261-66095/"},
     * {"title":"017","sid":18,"id":1786623,"size":0.42,"counts":3,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1451236322-82680/"},{"title":"016","sid":17,"id":1786622,"size":0
     * .32,"counts":4,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1451236322-28940/"},
     * {"title":"015","sid":16,"id":1784150,"size":0.3,"counts":3,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1451119458-18780/"},{"title":"014","sid":15,"id":1784149,"size":0
     * .54,"counts":3,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1451119458-79724/"},
     * {"title":"013","sid":14,"id":1784148,"size":0.25,"counts":5,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1451119458-61059/"},{"title":"012","sid":13,"id":1784147,"size":0
     * .18,"counts":3,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1451119458-19356/"},
     * {"title":"011","sid":12,"id":1784146,"size":0.27,"counts":3,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1451119458-12578/"},{"title":"010","sid":11,"id":1784145,"size":0
     * .39,"counts":3,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1451119458-91403/"},
     * {"title":"009","sid":10,"id":1784144,"size":0.2,"counts":4,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1451119458-33290/"},{"title":"008","sid":9,"id":1784143,"size":0
     * .21,"counts":3,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1451119458-58648/"},
     * {"title":"007","sid":8,"id":1784142,"size":0.21,"counts":3,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1451119458-91635/"},{"title":"006","sid":7,"id":1784141,"size":0
     * .32,"counts":4,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1451119458-48848/"},
     * {"title":"005","sid":6,"id":1784140,"size":0.18,"counts":3,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1451119458-40022/"},{"title":"004","sid":5,"id":1784139,"size":0
     * .36,"counts":4,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1451119458-79312/"},
     * {"title":"003","sid":4,"id":1784138,"size":0.18,"counts":3,"iszm":0,"surl":"http://www
     * .tuku.cc/comic/19498/n-1451119458-50254/"},{"title":"002","sid":3,"id":1784137,"size":0
     * .36,"counts":4,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1451119458-35964/"},
     * {"title":"001","sid":2,"id":1784136,"size":0.6,"counts":4,"iszm":0,"surl":"http://www.tuku
     * .cc/comic/19498/n-1451119459-48579/"},{"title":"000","sid":1,"id":1784135,"size":0.27,
     * "counts":3,"iszm":0,"surl":"http://www.tuku.cc/comic/19498/n-1451119459-94289/"}]
     */

    private int status;
    /**
     * title : 第252话
     * sid : 259
     * id : 2007942
     * size : 0.48
     * counts : 8
     * iszm : 0
     * surl : http://www.tuku.cc/comic/19498/n-1470801122-55057/
     */

    private List<DataBean> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String title;
        private int sid;
        private int id;
        private double size;
        private int counts;
        private int iszm;
        private String surl;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getSid() {
            return sid;
        }

        public void setSid(int sid) {
            this.sid = sid;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public double getSize() {
            return size;
        }

        public void setSize(double size) {
            this.size = size;
        }

        public int getCounts() {
            return counts;
        }

        public void setCounts(int counts) {
            this.counts = counts;
        }

        public int getIszm() {
            return iszm;
        }

        public void setIszm(int iszm) {
            this.iszm = iszm;
        }

        public String getSurl() {
            return surl;
        }

        public void setSurl(String surl) {
            this.surl = surl;
        }
    }
}
