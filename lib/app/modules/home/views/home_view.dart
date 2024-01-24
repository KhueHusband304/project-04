import 'package:flutter/material.dart';

import 'package:get/get.dart';

import '../../../../core/app_export.dart';
import '../../../../widgets/app_bar/appbar_title.dart';
import '../../../../widgets/app_bar/appbar_title_searchview.dart';
import '../../../../widgets/app_bar/custom_app_bar.dart';
import '../../../../widgets/custom_bottom_bar.dart';
import '../controllers/home_controller.dart';

class HomeView extends GetView<HomeController> {
  HomeView({Key? key}) : super(key: key);
  final TextEditingController searchController = TextEditingController();
  final PageController pageController = PageController();
  final RxInt currentIndex = 0.obs;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: _buildAppBar(),
      body: _buildBody(),
      //bottomNavigationBar: _buildBottomBar(),
    );
  }

  PreferredSizeWidget _buildAppBar() {
    return CustomAppBar(
      centerTitle: true,
      title: Row(
        children: [
          AppbarTitle(
            text: "Shop",
            margin: EdgeInsets.only(top: 6.v),
          ),
          AppbarTitleSearchview(
            margin: EdgeInsets.only(
              left: 19.h,
              bottom: 3.v,
            ),
            hintText: "Search",
            controller: searchController,
          ),
        ],
      ),
    );
  }

  Widget _buildBody() {
    return PageView(
      controller: pageController,
      onPageChanged: (index) {
        currentIndex.value = index;
      },
      children: [
        // FlashSaleFullPage(),
        // WishlistPage(),
        Container(), // Placeholder for User page
        // CartPage(),
        // FullProfilePage(),
      ],
    );
  }

  // Widget _buildBottomBar() {
  //   return Obx(() => CustomBottomBar(
  //         currentIndex: currentIndex.value,
  //         onChanged: (index) {
  //           pageController.jumpToPage(index);
  //         },
  //       ));
  // }
}
