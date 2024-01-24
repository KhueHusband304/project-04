import 'package:flutter/material.dart';
import 'package:project/theme/theme_helper.dart';
import '../core/app_export.dart';

/// A collection of pre-defined text styles for customizing text appearance,
/// categorized by different font families and weights.
/// Additionally, this class includes extensions on [TextStyle] to easily apply specific font families to text.

class CustomTextStyles {
  // Body text style
  static get bodyLargeBlack90001 => theme.textTheme.bodyLarge!.copyWith(
        color: appTheme.black90001,
        fontWeight: FontWeight.w400,
      );
  static get bodyLargeBlack90002 => theme.textTheme.bodyLarge!.copyWith(
        color: appTheme.black90002,
        fontWeight: FontWeight.w400,
      );
  static get bodyLargeBlack9000219 => theme.textTheme.bodyLarge!.copyWith(
        color: appTheme.black90002,
        fontSize: 19.fSize,
      );
  static get bodyLargeBlack90002_1 => theme.textTheme.bodyLarge!.copyWith(
        color: appTheme.black90002,
      );
  static get bodyLargeBlue80001 => theme.textTheme.bodyLarge!.copyWith(
        color: appTheme.blue80001,
      );
  static get bodyLargeGray900 => theme.textTheme.bodyLarge!.copyWith(
        color: appTheme.gray900,
        fontWeight: FontWeight.w400,
      );
  static get bodyLargeGray90001 => theme.textTheme.bodyLarge!.copyWith(
        color: appTheme.gray90001,
        fontSize: 19.fSize,
      );
  static get bodyLargeOnErrorContainer => theme.textTheme.bodyLarge!.copyWith(
        color: theme.colorScheme.onErrorContainer.withOpacity(1),
      );
  static get bodyLargeRalewayBlack90002 =>
      theme.textTheme.bodyLarge!.raleway.copyWith(
        color: appTheme.black90002,
        fontSize: 17.fSize,
        fontWeight: FontWeight.w400,
      );
  static get bodyMediumBlueA700 => theme.textTheme.bodyMedium!.copyWith(
        color: appTheme.blueA700,
        fontSize: 13.fSize,
      );
  static get bodyMediumGray90001 => theme.textTheme.bodyMedium!.copyWith(
        color: appTheme.gray90001,
        fontWeight: FontWeight.w300,
      );
  static get bodyMediumGray90001Light => theme.textTheme.bodyMedium!.copyWith(
        color: appTheme.gray90001.withOpacity(0.67),
        fontWeight: FontWeight.w300,
      );
  static get bodyMediumff000000 => theme.textTheme.bodyMedium!.copyWith(
        color: Color(0XFF000000),
      );
  static get bodySmall10 => theme.textTheme.bodySmall!.copyWith(
        fontSize: 10.fSize,
      );
  static get bodySmall11 => theme.textTheme.bodySmall!.copyWith(
        fontSize: 11.fSize,
      );
  static get bodySmallIndigo100 => theme.textTheme.bodySmall!.copyWith(
        color: appTheme.indigo100,
      );
  static get bodySmallOnErrorContainer => theme.textTheme.bodySmall!.copyWith(
        color: theme.colorScheme.onErrorContainer.withOpacity(1),
      );
  // Headline text style
  static get headlineMediumBlack90002 =>
      theme.textTheme.headlineMedium!.copyWith(
        color: appTheme.black90002,
        fontWeight: FontWeight.w500,
      );
  static get headlineMediumBlack90002ExtraBold =>
      theme.textTheme.headlineMedium!.copyWith(
        color: appTheme.black90002,
        fontSize: 26.fSize,
        fontWeight: FontWeight.w800,
      );
  static get headlineMediumIndigo900 =>
      theme.textTheme.headlineMedium!.copyWith(
        color: appTheme.indigo900,
        fontSize: 29.fSize,
        fontWeight: FontWeight.w500,
      );
  static get headlineMediumOnErrorContainer =>
      theme.textTheme.headlineMedium!.copyWith(
        color: theme.colorScheme.onErrorContainer.withOpacity(1),
        fontWeight: FontWeight.w500,
      );
  static get headlineMediumOnErrorContainer29 =>
      theme.textTheme.headlineMedium!.copyWith(
        color: theme.colorScheme.onErrorContainer.withOpacity(1),
        fontSize: 29.fSize,
      );
  // Label text style
  static get labelLarge12 => theme.textTheme.labelLarge!.copyWith(
        fontSize: 12.fSize,
      );
  static get labelLargeBlack90002 => theme.textTheme.labelLarge!.copyWith(
        color: appTheme.black90002,
      );
  static get labelLargeBlack90002Bold => theme.textTheme.labelLarge!.copyWith(
        color: appTheme.black90002,
        fontWeight: FontWeight.w700,
      );
  static get labelLargeBlue20001 => theme.textTheme.labelLarge!.copyWith(
        color: appTheme.blue20001,
        fontWeight: FontWeight.w800,
      );
  static get labelLargeBlueA700 => theme.textTheme.labelLarge!.copyWith(
        color: appTheme.blueA700,
        fontSize: 12.fSize,
      );
  static get labelLargeBold => theme.textTheme.labelLarge!.copyWith(
        fontSize: 12.fSize,
        fontWeight: FontWeight.w700,
      );
  static get labelLargeBold_1 => theme.textTheme.labelLarge!.copyWith(
        fontWeight: FontWeight.w700,
      );
  static get labelLargeIndigo10001 => theme.textTheme.labelLarge!.copyWith(
        color: appTheme.indigo10001,
      );
  static get labelLargeNunitoSans =>
      theme.textTheme.labelLarge!.nunitoSans.copyWith(
        fontSize: 12.fSize,
        fontWeight: FontWeight.w600,
      );
  static get labelLargeNunitoSansBlack90002 =>
      theme.textTheme.labelLarge!.nunitoSans.copyWith(
        color: appTheme.black90002,
        fontSize: 12.fSize,
        fontWeight: FontWeight.w600,
      );
  static get labelLargeNunitoSansBlack90002SemiBold =>
      theme.textTheme.labelLarge!.nunitoSans.copyWith(
        color: appTheme.black90002,
        fontWeight: FontWeight.w600,
      );
  static get labelLargeNunitoSansBold =>
      theme.textTheme.labelLarge!.nunitoSans.copyWith(
        fontSize: 12.fSize,
        fontWeight: FontWeight.w700,
      );
  static get labelLargeNunitoSansOnErrorContainer =>
      theme.textTheme.labelLarge!.nunitoSans.copyWith(
        color: theme.colorScheme.onErrorContainer.withOpacity(1),
        fontSize: 12.fSize,
        fontWeight: FontWeight.w700,
      );
  static get labelLargeNunitoSansSemiBold =>
      theme.textTheme.labelLarge!.nunitoSans.copyWith(
        fontSize: 12.fSize,
        fontWeight: FontWeight.w600,
      );
  static get labelLargeNunitoSansff000000 =>
      theme.textTheme.labelLarge!.nunitoSans.copyWith(
        color: Color(0XFF000000),
        fontWeight: FontWeight.w600,
      );
  static get labelLargeOnErrorContainer => theme.textTheme.labelLarge!.copyWith(
        color: theme.colorScheme.onErrorContainer.withOpacity(1),
        fontSize: 12.fSize,
      );
  static get labelLargeOnErrorContainerBold =>
      theme.textTheme.labelLarge!.copyWith(
        color: theme.colorScheme.onErrorContainer.withOpacity(1),
        fontWeight: FontWeight.w700,
      );
  static get labelLargeOnErrorContainerSemiBold =>
      theme.textTheme.labelLarge!.copyWith(
        color: theme.colorScheme.onErrorContainer.withOpacity(1),
        fontWeight: FontWeight.w600,
      );
  static get labelLargeOnErrorContainer_1 =>
      theme.textTheme.labelLarge!.copyWith(
        color: theme.colorScheme.onErrorContainer.withOpacity(1),
      );
  static get labelLargePrimary => theme.textTheme.labelLarge!.copyWith(
        color: theme.colorScheme.primary,
      );
  static get labelLargePrimary_1 => theme.textTheme.labelLarge!.copyWith(
        color: theme.colorScheme.primary,
      );
  static get labelLargeRed300 => theme.textTheme.labelLarge!.copyWith(
        color: appTheme.red300,
        fontWeight: FontWeight.w600,
      );
  static get labelMediumNunitoSans =>
      theme.textTheme.labelMedium!.nunitoSans.copyWith(
        fontSize: 10.fSize,
        fontWeight: FontWeight.w600,
      );
  static get labelMediumNunitoSansGray90001 =>
      theme.textTheme.labelMedium!.nunitoSans.copyWith(
        color: appTheme.gray90001,
        fontSize: 10.fSize,
        fontWeight: FontWeight.w600,
      );
  static get labelMediumOnErrorContainer =>
      theme.textTheme.labelMedium!.copyWith(
        color: theme.colorScheme.onErrorContainer.withOpacity(1),
        fontWeight: FontWeight.w700,
      );
  static get labelMediumRed300 => theme.textTheme.labelMedium!.copyWith(
        color: appTheme.red300,
      );
  // Title text style
  static get titleLarge20 => theme.textTheme.titleLarge!.copyWith(
        fontSize: 20.fSize,
      );
  static get titleLargeBlack90002 => theme.textTheme.titleLarge!.copyWith(
        color: appTheme.black90002,
        fontSize: 20.fSize,
        fontWeight: FontWeight.w800,
      );
  static get titleLargeBlack9000220 => theme.textTheme.titleLarge!.copyWith(
        color: appTheme.black90002,
        fontSize: 20.fSize,
      );
  static get titleLargeBlack9000222 => theme.textTheme.titleLarge!.copyWith(
        color: appTheme.black90002,
        fontSize: 22.fSize,
      );
  static get titleLargeBlueA700 => theme.textTheme.titleLarge!.copyWith(
        color: appTheme.blueA700,
        fontSize: 20.fSize,
      );
  static get titleLargeExtraBold => theme.textTheme.titleLarge!.copyWith(
        fontSize: 20.fSize,
        fontWeight: FontWeight.w800,
      );
  static get titleLargeGray20002 => theme.textTheme.titleLarge!.copyWith(
        color: appTheme.gray20002,
        fontSize: 20.fSize,
      );
  static get titleLargeNunitoSansGray10001 =>
      theme.textTheme.titleLarge!.nunitoSans.copyWith(
        color: appTheme.gray10001,
        fontSize: 22.fSize,
        fontWeight: FontWeight.w300,
      );
  static get titleLargeNunitoSansPrimary =>
      theme.textTheme.titleLarge!.nunitoSans.copyWith(
        color: theme.colorScheme.primary,
        fontSize: 22.fSize,
        fontWeight: FontWeight.w300,
      );
  static get titleLargeOnErrorContainer => theme.textTheme.titleLarge!.copyWith(
        color: theme.colorScheme.onErrorContainer.withOpacity(1),
        fontWeight: FontWeight.w500,
      );
  static get titleLargePrimary => theme.textTheme.titleLarge!.copyWith(
        color: theme.colorScheme.primary,
        fontSize: 20.fSize,
      );
  static get titleMedium16 => theme.textTheme.titleMedium!.copyWith(
        fontSize: 16.fSize,
      );
  static get titleMedium18 => theme.textTheme.titleMedium!.copyWith(
        fontSize: 18.fSize,
      );
  static get titleMedium19 => theme.textTheme.titleMedium!.copyWith(
        fontSize: 19.fSize,
      );
  static get titleMediumBlack90002 => theme.textTheme.titleMedium!.copyWith(
        color: appTheme.black90002,
        fontSize: 16.fSize,
      );
  static get titleMediumBlack9000218 => theme.textTheme.titleMedium!.copyWith(
        color: appTheme.black90002,
        fontSize: 18.fSize,
      );
  static get titleMediumBlack90002Medium =>
      theme.textTheme.titleMedium!.copyWith(
        color: appTheme.black90002,
        fontSize: 16.fSize,
        fontWeight: FontWeight.w500,
      );
  static get titleMediumBlack90002Medium16 =>
      theme.textTheme.titleMedium!.copyWith(
        color: appTheme.black90002,
        fontSize: 16.fSize,
        fontWeight: FontWeight.w500,
      );
  static get titleMediumBlack90002Medium19 =>
      theme.textTheme.titleMedium!.copyWith(
        color: appTheme.black90002,
        fontSize: 19.fSize,
        fontWeight: FontWeight.w500,
      );
  static get titleMediumBlack90002Medium_1 =>
      theme.textTheme.titleMedium!.copyWith(
        color: appTheme.black90002,
        fontWeight: FontWeight.w500,
      );
  static get titleMediumBlack90002Medium_2 =>
      theme.textTheme.titleMedium!.copyWith(
        color: appTheme.black90002,
        fontWeight: FontWeight.w500,
      );
  static get titleMediumBlack90002SemiBold =>
      theme.textTheme.titleMedium!.copyWith(
        color: appTheme.black90002,
        fontSize: 16.fSize,
        fontWeight: FontWeight.w600,
      );
  static get titleMediumBlack90002_1 => theme.textTheme.titleMedium!.copyWith(
        color: appTheme.black90002,
      );
  static get titleMediumBlue80001 => theme.textTheme.titleMedium!.copyWith(
        color: appTheme.blue80001,
        fontSize: 16.fSize,
        fontWeight: FontWeight.w500,
      );
  static get titleMediumBlue8000116 => theme.textTheme.titleMedium!.copyWith(
        color: appTheme.blue80001,
        fontSize: 16.fSize,
      );
  static get titleMediumBlueA700 => theme.textTheme.titleMedium!.copyWith(
        color: appTheme.blueA700,
        fontSize: 16.fSize,
        fontWeight: FontWeight.w500,
      );
  static get titleMediumGray30001 => theme.textTheme.titleMedium!.copyWith(
        color: appTheme.gray30001,
        fontWeight: FontWeight.w500,
      );
  static get titleMediumGray400 => theme.textTheme.titleMedium!.copyWith(
        color: appTheme.gray400,
        fontSize: 16.fSize,
        fontWeight: FontWeight.w500,
      );
  static get titleMediumIndigo100 => theme.textTheme.titleMedium!.copyWith(
        color: appTheme.indigo100,
        fontSize: 16.fSize,
      );
  static get titleMediumIndigo200 => theme.textTheme.titleMedium!.copyWith(
        color: appTheme.indigo200,
        fontSize: 16.fSize,
        fontWeight: FontWeight.w500,
      );
  static get titleMediumMedium => theme.textTheme.titleMedium!.copyWith(
        fontSize: 18.fSize,
        fontWeight: FontWeight.w500,
      );
  static get titleMediumMedium16 => theme.textTheme.titleMedium!.copyWith(
        fontSize: 16.fSize,
        fontWeight: FontWeight.w500,
      );
  static get titleMediumNunitoSansBlack90002 =>
      theme.textTheme.titleMedium!.nunitoSans.copyWith(
        color: appTheme.black90002,
        fontSize: 16.fSize,
      );
  static get titleMediumNunitoSansBlack90002SemiBold =>
      theme.textTheme.titleMedium!.nunitoSans.copyWith(
        color: appTheme.black90002,
        fontSize: 16.fSize,
        fontWeight: FontWeight.w600,
      );
  static get titleMediumOnErrorContainer =>
      theme.textTheme.titleMedium!.copyWith(
        color: theme.colorScheme.onErrorContainer.withOpacity(1),
        fontSize: 16.fSize,
      );
  static get titleMediumOnErrorContainerMedium =>
      theme.textTheme.titleMedium!.copyWith(
        color: theme.colorScheme.onErrorContainer.withOpacity(1),
        fontSize: 16.fSize,
        fontWeight: FontWeight.w500,
      );
  static get titleMediumOnPrimary => theme.textTheme.titleMedium!.copyWith(
        color: theme.colorScheme.onPrimary,
        fontSize: 18.fSize,
      );
  static get titleMediumPrimary => theme.textTheme.titleMedium!.copyWith(
        color: theme.colorScheme.primary,
        fontSize: 18.fSize,
      );
  static get titleMediumPrimaryExtraBold =>
      theme.textTheme.titleMedium!.copyWith(
        color: theme.colorScheme.primary,
        fontSize: 16.fSize,
        fontWeight: FontWeight.w800,
      );
  static get titleMediumPrimaryMedium => theme.textTheme.titleMedium!.copyWith(
        color: theme.colorScheme.primary,
        fontSize: 18.fSize,
        fontWeight: FontWeight.w500,
      );
  static get titleMediumPrimaryMedium16 =>
      theme.textTheme.titleMedium!.copyWith(
        color: theme.colorScheme.primary,
        fontSize: 16.fSize,
        fontWeight: FontWeight.w500,
      );
  static get titleMediumRed200 => theme.textTheme.titleMedium!.copyWith(
        color: appTheme.red200,
        fontWeight: FontWeight.w500,
      );
  static get titleMediumRed300 => theme.textTheme.titleMedium!.copyWith(
        color: appTheme.red300,
      );
  static get titleMediumRed300_1 => theme.textTheme.titleMedium!.copyWith(
        color: appTheme.red300,
      );
  static get titleMedium_1 => theme.textTheme.titleMedium!;
  static get titleSmall15 => theme.textTheme.titleSmall!.copyWith(
        fontSize: 15.fSize,
      );
  static get titleSmall15_1 => theme.textTheme.titleSmall!.copyWith(
        fontSize: 15.fSize,
      );
  static get titleSmallBlack90002 => theme.textTheme.titleSmall!.copyWith(
        color: appTheme.black90002,
        fontWeight: FontWeight.w500,
      );
  static get titleSmallBlack9000215 => theme.textTheme.titleSmall!.copyWith(
        color: appTheme.black90002,
        fontSize: 15.fSize,
      );
  static get titleSmallBlack90002Medium => theme.textTheme.titleSmall!.copyWith(
        color: appTheme.black90002,
        fontSize: 15.fSize,
        fontWeight: FontWeight.w500,
      );
  static get titleSmallBlack90002Medium15 =>
      theme.textTheme.titleSmall!.copyWith(
        color: appTheme.black90002,
        fontSize: 15.fSize,
        fontWeight: FontWeight.w500,
      );
  static get titleSmallBlue80001 => theme.textTheme.titleSmall!.copyWith(
        color: appTheme.blue80001,
        fontWeight: FontWeight.w500,
      );
  static get titleSmallBlueA700 => theme.textTheme.titleSmall!.copyWith(
        color: appTheme.blueA700,
        fontSize: 15.fSize,
      );
  static get titleSmallMedium => theme.textTheme.titleSmall!.copyWith(
        fontWeight: FontWeight.w500,
      );
  static get titleSmallNunitoSansBlack90002 =>
      theme.textTheme.titleSmall!.nunitoSans.copyWith(
        color: appTheme.black90002,
        fontWeight: FontWeight.w600,
      );
  static get titleSmallOnErrorContainer => theme.textTheme.titleSmall!.copyWith(
        color: theme.colorScheme.onErrorContainer.withOpacity(1),
        fontWeight: FontWeight.w600,
      );
  static get titleSmallOnErrorContainerMedium =>
      theme.textTheme.titleSmall!.copyWith(
        color: theme.colorScheme.onErrorContainer.withOpacity(1),
        fontSize: 15.fSize,
        fontWeight: FontWeight.w500,
      );
  static get titleSmallOnErrorContainerMedium_1 =>
      theme.textTheme.titleSmall!.copyWith(
        color: theme.colorScheme.onErrorContainer.withOpacity(1),
        fontWeight: FontWeight.w500,
      );
  static get titleSmallPoppinsBluegray100 =>
      theme.textTheme.titleSmall!.poppins.copyWith(
        color: appTheme.blueGray100,
        fontWeight: FontWeight.w500,
      );
  static get titleSmallPrimary => theme.textTheme.titleSmall!.copyWith(
        color: theme.colorScheme.primary,
        fontSize: 15.fSize,
        fontWeight: FontWeight.w800,
      );
  static get titleSmallPrimary15 => theme.textTheme.titleSmall!.copyWith(
        color: theme.colorScheme.primary,
        fontSize: 15.fSize,
      );
  static get titleSmallPrimaryMedium => theme.textTheme.titleSmall!.copyWith(
        color: theme.colorScheme.primary,
        fontSize: 15.fSize,
        fontWeight: FontWeight.w500,
      );
  static get titleSmallPrimaryMedium15 => theme.textTheme.titleSmall!.copyWith(
        color: theme.colorScheme.primary,
        fontSize: 15.fSize,
        fontWeight: FontWeight.w500,
      );
  static get titleSmallPrimaryMedium_1 => theme.textTheme.titleSmall!.copyWith(
        color: theme.colorScheme.primary,
        fontWeight: FontWeight.w500,
      );
  static get titleSmallRed200 => theme.textTheme.titleSmall!.copyWith(
        color: appTheme.red200,
      );
  static get titleSmallRed200ExtraBold => theme.textTheme.titleSmall!.copyWith(
        color: appTheme.red200,
        fontWeight: FontWeight.w800,
      );
}

extension on TextStyle {
  TextStyle get raleway {
    return copyWith(
      fontFamily: 'Raleway',
    );
  }

  TextStyle get nunitoSans {
    return copyWith(
      fontFamily: 'Nunito Sans',
    );
  }

  TextStyle get poppins {
    return copyWith(
      fontFamily: 'Poppins',
    );
  }
}
