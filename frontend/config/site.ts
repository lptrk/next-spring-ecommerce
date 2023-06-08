export type SiteConfig = typeof siteConfig

export const siteConfig = {
  name: "Next Spring",
  heading_one:
    "Lorem ipsum dolor sit amet",
  heading_two: "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.",
  mainNav: [
    {
      title: "Home",
      href: "/",
    },
    {
      title: "Products",
      href: "/products"
    }, {
      title: "Categories",
      href: "/categories"
    }
  ],
  links: {
    github: "https://github.com/lptrk",
  },
}
