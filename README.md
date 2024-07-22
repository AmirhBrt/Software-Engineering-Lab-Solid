# گزارش کار آزمایش دوم آز نرم افزار
در این آزمایش قصد داریم یک سیستم نرم‌افزاری که از اصول SOLID پیروی نمی‌کند را بررسی کنیم و در صورت نیاز، مجدد آن را با اتکا به این اصول طراحی و بازتولید کنیم. با پیاده‌سازی این اصول، قصد داریم نرم‌افزاری ماژولار، انعطاف‌پذیر و مقاوم‌تری ایجاد کنیم که نه تنها اصلاحات و گسترش‌های آینده را ساده‌تر می‌کند، بلکه خوانایی و قابلیت استفاده مجدد کد را بهبود می‌بخشد و همکاری توسعه‌دهندگان پروژه را مؤثرتر می‌سازد.
## اعضای تیم
- همراز عرفاتی ۹۹۱۰۹۷۹۹
- امیرحسین براتی ۹۹۱۰۱۳۰۸
- امیرحسین عابدی ۹۹۱۰۵۵۹۴
## بخش اول: پیاده‌سازی یک روش پرداخت دیگر
با توجه به دستور کار آزمایش، در این بخش قصد داریم تا یک روش پرداخت تلفنی را به روش‌های پرداخت سیستم اضافه کنیم. برای اینکار با توجه به نحوه پیاده‌سازی سیستم، باید یک کلاس جدید برای این روش پرداخت ایجاد کنیم که از رابط `OrderService` ارث‌بری می‌کند. همچنین باید تغییرات لازم را در این رابط اعمال کنیم تا با توجه به سیستم قبلی بتواند فعالیت خود را ادامه دهد.

### تغییر کلاس OrderService
بنابراین در ابتدا در رابط `OrderService` دو تابع برای ثبت و پرداخت این روش جدید اضافه می‌کنیم:

![تغییرات اعمال شده در رابط OrderService](./resources/1-1.png)

### پیاده‌سازی کلاس PhoneOrderSerivce

حال با توجه به این تغییرات، کلاس `PhoneOrderService` را به شکل زیر پیاده می‌کنیم. مشاهده می‌کنیم که علاوه‌بر تابع‌هایی که اکنون اضافه کردیم، می‌بایست سایر تابع‌هایی که از قبل برای دیگر روش‌ها در سیستم موجود بودند را هم در کلاس  خود پیاده کنیم:

![پیاده‌سازی کلاس PhoneOrderSerivce](./resources/1-2.png)

### اضافه کردن تابع‌های جدید به کلاس‌های OnSiteOrderService و OnlineOrderService

با توجه به اینکه کلاس‌های `OnSiteOrderService` و `OnlineOrderService` از رابط `OrderService` ارث‌بری می‌کنند، بایست تمامی توابع تعریف شده در این رابط را پیاده‌سازی کنند. بنابراین باید پیاده‌سازی دو تابع `phoneOrderRegister` و `phoneOrderPayment` را به این کلاس‌ها اضافه کنیم:

![اضافه کردن توابع به کلاس OnSiteOrderService](./resources/1-3.png)
![اضافه کردن توابع به کلاس OnlineOrderService](./resources/1-4.png)

### تغییر کلاس Main برای اضافه کردن سرویس جدید

حال نوبت به این می‌رسد که سرویس جدید را در روند برنامه اضافه کنیم. برای اینکار تغییرات زیر را در تابع `main` اضافه می‌کنیم:

![](./resources/1-5.png)

اکنون می‌توانیم در منوی انتخاب روش پرداخت، با انتخاب عدد سه، پرداخت را به صورت تلفنی انجام دهیم. 

جدول تغییرات به صورت زیر است

<table dir='rtl'>
<tbody>
<tr>
<td width="64">
<p><strong>ردیف</strong></p>
</td>
<td width="198">
<p><strong>محل اعمال تغییرات (کلاس/واسط)</strong></p>
</td>
<td width="141">
<p><strong>عنوان تغییر</strong></p>
</td>
<td width="292">
<p><strong>شرحی کوتاه از تغییر</strong></p>
</td>
</tr>
<tr>
<td width="64">
<p><strong>۱</strong></p>
</td>
<td width="198">
<p>OrderService</p>
</td>
<td width="141">
<p>افزودن تابع برای پشتیبانی از کلاس جدید</p>
</td>
<td width="292">
<p>افزودن دو تابع void با نام phoneOrderRegister و phoneOrderPayment برای پشتیبانی از روش جدید رجیستر و پرداخت</p>
</td>
</tr>

<tr>
<td width="64">
<p><strong>۲</strong></p>
</td>
<td width="198">
<p>PhoneOrderService</p>
</td>
<td width="141">
<p>کلاس جدید برای پشتیبانی از خدمات تلفنی</p>
</td>
<td width="292">
<p>افزودن کلاس جدید PhoneOrderService برای پیاده‌سازی دو تابع void با نام‌های phoneOrderPayment و phoneOrderRegister و بدنه‌ تابع‌های دیگر خالی</p>
</td>
</tr>

<tr>
<td width="64">
<p><strong>۳</strong></p>
</td>
<td width="198">
<p>OnSiteOrderService</p>
</td>
<td width="141">
<p>افزودن تابع برای رفع خطای کامپایل</p>
</td>
<td width="292">
<p>پیاده‌سازی دو تابع جدید phoneOrderRegister و phoneOrderPayment برای پیروی از اینترفیس OrderService</p>
</td>
</tr>

<tr>
<td width="64">
<p><strong>۴</strong></p>
</td>
<td width="198">
<p>OnlineOrderService</p>
</td>
<td width="141">
<p>افزودن تابع برای رفع خطای کامپایل</p>
</td>
<td width="292">
<p>پیاده‌سازی دو تابع جدید phoneOrderRegister و phoneOrderPayment برای پیروی از اینترفیس OrderService</p>
</td>
</tr>

<tr>
<td width="64">
<p><strong>۵</strong></p>
</td>
<td width="198">
<p>Main</p>
</td>
<td width="141">
<p>افزودن تابع برای رفع خطای کامپایل</p>
</td>
<td width="292">
<p>اضافه کردن خطوط کد جدید در خطوط ۴۷ تا ۴۹ و ۵۸ تا ۵۹ فایل Main.java برای اضافه کردن روش پرداخت تلفنی جدید</p>
</td>
</tr>

</tbody>
</table>

## بخش دوم: تحلیل و بررسی برنامه از منظر SOLID

موارد نقض شده را در جدول پایین مشاهده می‌کنیم، تمامی موارد بر اساس کد نهایی بخش اول هستند.

<table dir='rtl'>
<tbody>
<tr>
<td rowspan="2" width="240">
<p>اصل 1</p>
<p>Single Responsibility</p>
</td>
<td width="95">
<p><strong>موارد تحقق</strong></p>
</td>
<td width="454">
<p>Food, Order, Main, OrderService, OnlineOrderService, OnSiteOrderService, PhoneOrderService</p>
</td>
</tr>
<tr>
<td>
<p><strong>موارد نقض</strong></p>
</td>
<td>
<p></p>
</td>
</tr>
<tr>
<td rowspan="2">
<p>اصل 2</p>
<p>Open-Close Principle (OCP)</p>
</td>
<td>
<p><strong>موارد تحقق</strong></p>
</td>
<td>
<p>همه‌ی کلاس‌ها به غیر از Main</p>
</td>
</tr>
<tr>
<td>
<p><strong>موارد نقض</strong></p>
</td>
<td>
<p>Main</p>
</td>
</tr>
<tr>
<td rowspan="2">
<p>اصل 3</p>
<p>Liskov Substitution Principle</p>
</td>
<td>
<p><strong>موارد تحقق</strong></p>
</td>
<td>
<p>در همه کلاس‌ها رعایت شده است</p>
</td>
</tr>
<tr>
<td>
<p><strong>موارد نقض</strong></p>
</td>
<td>
<p>&nbsp;</p>
</td>
</tr>
<tr>
<td rowspan="2">
<p>اصل 4</p>
<p>Interface Segregation Principle</p>
</td>
<td>
<p><strong>موارد تحقق</strong></p>
</td>
<td>
<p></p>
</td>
</tr>
<tr>
<td>
<p><strong>موارد نقض</strong></p>
</td>
<td>
<p>این مورد در OrderService interface که تنها اینترفیس کد است رعایت نشده است.</p>
</td>
</tr>
<tr>
<td rowspan="2">
<p>اصل 5</p>
<p>Dependency Inversion Principle</p>
</td>
<td>
<p><strong>موارد تحقق</strong></p>
</td>
<td>
<p>همه کلاس‌ها جز Main</p>
</td>
</tr>
<tr>
<td>
<p><strong>موارد نقض</strong></p>
</td>
<td>
<p>Main</p>
</td>
</tr>
</tbody>
</table>

<div dir="rtl">
کلاس Food, Main, Order فقط یک وظیفه را بر عهده دارند و به ترتیب مشخص کردن نوع غذا و قیمت آن، ساختن سرویس‌های مختلف و شروع استفاده برای مشتری و نگه‌داشتن سفارش مشتری است. همینطور در کلاس‌های OrderService هم این اصل رعایت شده است چون هرکدام وظیفه هندل کردن یک نوع payment را دارند.

</br>
</br>

در کلاس Main اصل OCP رعایت نشده‌است. در این کلاس با اضافه شدن روش‌های پرداخت جدید نیاز به تغییر کد درون آن هستیم بنابراین باید کد Main به روش دیگری نوشته شود.

</br>
</br>

اصل ISP برای اینترفیس OrderService رعایت نشده است چرا که کلاس‌هایی که این اینترفیس را implement کرده‌اند ملزوم به پیاده‌سازی تابع‌هایی هستند که متعلق به آن‌ها نیست و باید بدنه آن را خالی می‌گذارند. به عبارتی مدل تابع‌های موجود در این اینترفیس باعث شده است که این تابع‌ها متعلق به implementation ها باشند به جای اینکه وابسته به abstraction باشند و این برای اصل Dependency Inversion هم مشکل به وجود آورده است.

</br>
</br>

در تابع Main این اصل رعایت نشده است چرا که بسته به اینکه چه کلاسی اینترفیس را پیاده‌سازی کرده است باید رفتار متفاوتی از خود نشان دهد. این کلاس به جای اینکه بر روی abstraction اینترفیس OrderService تمرکز کند، به این دقت می‌کند که چه کلاسی این اینترفیس را پیاده‌سازی کرده است.
</div>