import { useRouter } from "next/router";
import en from "../locales/en";
import vi from "../locales/vi";

export const useLanguage = () =>
{
  const { locale } = useRouter();
  const t = locale === "en" ? en : vi;
  return { t, locale };
};
