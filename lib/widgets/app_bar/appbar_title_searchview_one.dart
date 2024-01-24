import 'package:flutter/material.dart';
import 'package:project/core/app_export.dart';
import 'package:project/theme/theme_helper.dart';
import 'package:project/widgets/custom_search_view.dart';

// ignore: must_be_immutable
class AppbarTitleSearchviewOne extends StatelessWidget {
  AppbarTitleSearchviewOne({
    Key? key,
    this.hintText,
    this.controller,
    this.margin,
  }) : super(
          key: key,
        );

  String? hintText;

  TextEditingController? controller;

  EdgeInsetsGeometry? margin;

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: margin ?? EdgeInsets.zero,
      child: CustomSearchView(
        width: 248.h,
        controller: controller,
        hintText: "lbl_clothing".tr,
        borderDecoration: SearchViewStyleHelper.fillIndigo,
        fillColor: appTheme.indigo50,
      ),
    );
  }
}