// import 'package:flutter/material.dart';

// import 'package:get/get.dart';

// import 'app/routes/app_pages.dart';
// import 'core/app_export.dart';
// import 'localization/app_localization.dart';

// void main() {
//   runApp(
//     GetMaterialApp(
//       debugShowCheckedModeBanner: false,
//       theme: theme,
//       translations: AppLocalization(),
//       locale: Get.deviceLocale, //for setting localization strings
//       fallbackLocale: Locale('en', 'US'),
//       title: 'shopcart',
//       initialRoute: AppPages.INITIAL,
//       getPages: AppPages.routes,
//     ),
//   );
// }

import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

import 'core/app_export.dart';
import 'localization/app_localization.dart';

void main() {
  WidgetsFlutterBinding.ensureInitialized();
  SystemChrome.setPreferredOrientations([
    DeviceOrientation.portraitUp,
  ]).then((value) {
    Logger.init(kReleaseMode ? LogMode.live : LogMode.debug);
    runApp(MyApp());
  });
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return Sizer(builder: (context, orientation, deviceType) {
      return GetMaterialApp(
        debugShowCheckedModeBanner: false,
        theme: theme,
        translations: AppLocalization(),
        locale: Get.deviceLocale, //for setting localization strings
        fallbackLocale: Locale('en', 'US'),
        title: 'shopcart',
        initialBinding: InitialBindings(),
        initialRoute: AppPages.INITIAL,
        getPages: AppPages.routes,
      );
    });
  }
}
