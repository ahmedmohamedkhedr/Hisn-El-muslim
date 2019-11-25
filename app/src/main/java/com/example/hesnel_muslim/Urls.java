package com.example.hesnel_muslim;

import android.webkit.WebView;

public class Urls {
    public static final String LANGUAGE_URL_AR = "https://www.hisnmuslim.com/api/ar/husn_ar.json";
    public static final String LANGUAGE_URL_EN = "https://www.hisnmuslim.com/api/en/husn_en.json";
    public static final String[] arJsonArrayKeys = {"إذكار الصباح والمساء", "ِأَذْكَارُ النَّــــــــــــــوْمِ", "أَذْكَارُ الاسْـــتِيقَاظِ مِنَ النَّـــومِ", "دعاء دخول الخلاءِ"
            , "دعاء الخروج من الخلاء", "الذكر قبل الوضوء", "الذكر بعد الفراغ من الوضوء", "الذكر عند الخروج من المنزلِ", "ِالذكر عند دخول المنزل", "دعاء الذهاب إلى المسجدِ",
            "ِدعاء دخول المسجد", "دعاء الخروج من المسجدِ", "ِأذكار الآذان", "دُعَـــــــاءُ لُبْسِ الثَّـــــــــــوْبِ", "دُعَـــاءُ لُبْسِ الثَّوْبِ الجَــــدِيدِ", "الدُّعَاءُ لِمَنْ لَبِسَ ثـَوْباً جَـدِيداً", "مَا يَقُــولُ إِذَا وَضَــــعَ ثـــَـــــوْبَهُ",
            "دعاء الاستفتاحِ", "ِدعاء الركوع", "دعاء الرفع من الركوعِ", "دعاء السجودِ", "دعاء الجلسة بين السجدتينِ", "دعاء سجود التلاوةِ", "التشهدِ", "ِالصلاة على النبي بعد التشهد", "الدعاء بعد التشهد الأخير قبل السلامِ",
            "ِالأذكار بعد السلام من الصلاة", "دعاء صلاة الاستخارةِ", "ِالدعاء إذا تقلب ليلا", "ِدعاء الفزع في النوم و من بُلِيَ بالوحشة", "ِما يفعل من رأى الرؤيا أو الحلم", "ِدعاء قنوت الوتر", "ِالذكر عقب السلام من الوتر",
            "ِدعاء الهم والحزن", "دعاء الكربِ", "ِدعاء لقاء العدو و ذي السلطان", "ِدعاء من خاف ظلم السلطان", "الدعاء على العدوِ", "ِما يقول من خاف قوما", "ِدعاء من أصابه وسوسة في الإيمان", "ِدعاء قضاء الدين", "دعاء الوسوسة في الصلاة و القراءةِ",
            "ِدعاء من استصعب عليه أمر", "ِما يقول ويفعل من أذنب ذنبا", "دعاء طرد الشيطان و وساوسهِ", "ِالدعاء حينما يقع ما لا يرضاه أو ُ غلب على أمره", "ﺗﻬنئة المولود له وجوابهِ", "ِما يعوذ به الأولاد", "ِالدعاء للمريض في عيادته", "ِفضل عيادة المريض",
            "ِدعاء المريض الذي يئس من حياته", "ِتلقين المحتضر", "دعاء من أصيب بمصيبةِ", "الدعاء عند إغماض الميتِ", "ِالدعاء للميت في الصلاة عليه", "ِالدعاء للفرط في الصلاة عليه", "دعاء التعزيةِ",
            "ِالدعاء عند إدخال الميت القبر", "الدعاء بعد دفن الميتِ", "دعاء زيارة القبورِ", "دعاء الريحِ", "ِدعاء الرعد", "ِمن أدعية الاستسقاء", "الدعاء إذا نزل المطرِ", "ِالذكر بعد نزول المطر", "ِمن أدعية الاستصحاء", "دعاء رؤية الهلالِ", "ِالدعاء عند إفطار الصائم",
            "الدعاء قبل الطعامِ", "الدعاء عند الفراغ من الطعامِ", "ِدعاء الضيف لصاحب الطعام", "التعريض بالدعاء لطلب الطعام أو الشرابِ", "الدعاء إذا أفطر عند أهل بيتِ", "ِدعاء الصائم إذا حضر الطعام ولم يفطر", "ِما يقول الصائم إذا سابه أحد", "ِالدعاء عند رؤية باكورة الثمر", "ِدعاء العطاس",
            "ما يقال للكافر إذا عطس فحمد اللهِ", "الدعاء للمتزوجِ", "ِدعاء المتزوج و شراء الدابة", "ِالدعاء قبل إتيان الزوجة", "دعاء الغضبِ", "ِدعاء من رأى مبتلى", "ِما يقال في اﻟﻤﺠلس", "كفارة اﻟﻤﺠلسِ", "الدعاء لمن صنع إليك معروفاِ", "الدعاء لمن صنع إليك معروفاِ", "ما يعصم الله به من الدجالِ",
            "الدعاء لمن قال إني أحبك في اللهِ", "الدعاء لمن عرض عليك مالهِ", "الدعاء لمن أقرض عند القضاءِ", "دعاء الخوف من الشركِ", "الدعاء لمن قال بارك الله فيكِ", "دعاء كراهية الطيرةِ", "ِدعاء الركوب", "ِدعاء السفر", "" +
            "دعاء دخول القرية أو البلدةِ", "دعاء دخول السوقِ", "ِالدعاء إذا تعس المركوب", "دعاء المسافر للمقيمِ", "ِدعاء المقيم للمسافر", "التكبير و التسبيح في سير السفرِ", "دعاء المسافر إذا أسحرِ", "الدعاء إذا نزل مترلا في سفر أو غيرهِ", "" +
            "ِذكر الرجوع من السفر", "ِما يقول من أتاه أمر يسره أو يكرهه", "ِفضل الصلاة على النبي صلى الله عليه و سلم", "ِإفشاء السلام", "ِكيف يرد السلام على الكافر إذا سلم",
            "ِالدُّعاءُ عِنْدَ سَمَاعِ صِياحِ الدِّيكِ ونَهِيقِ الْحِمَارِ", "دعاء نباح الكلاب بالليلِ", "ِالدعاء لمن سببته", "ِما يقول المسلم إذا مدح المسلم", "ما يقول المسلم إذا زكيِ", "ِكيف يلبي المحرم في الحج أو العمرة ؟", "ِالتكبير إذا أتى الركن الأسود",
            "الدعاء بين الركن اليماني والحجر الأسودِ", "دعاء الوقوف على الصفا والمروةِ", "ِالدعاء يوم عرفة", "", "ِالتكبير عند رمي الجمار مع كل حصاة", "ِدعاء التعجب والأمر السار",
            "ِما يفعل من أتاه أمر يسره", "ما يقول من أحس وجعا في جسدهِ", "دعاء من خشي أن يصيب شيئا بعينهِ", "ما يقال عند الفزعِ", "ما يقول عند الذبح أو النحرِ", "ما يقول لرد كيد مردة الشياطينِ", "الاستغفار و التوبةِ", "ِفضل التسبيح و التحميد، و التهليل، و التكبير", "ِكيف كان النبي يسبح؟",
            "من أنواع الخير والآداب الجامعةِ"};
    public static WebView wv;
}