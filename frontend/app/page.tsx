import Link from "next/link"

import {siteConfig} from "@/config/site"
import {buttonVariants} from "@/components/ui/button"
import { Icons } from "@/components/icons"

export default function Home() {
  return (
    <section className="container grid items-center gap-6 pb-8 pt-6 md:py-10">
      <div className="flex max-w-[61.25rem] flex-col items-start gap-2">
        <h1 className="text-3xl font-extrabold leading-tight tracking-tighter md:text-4xl">
          {siteConfig.heading_one}
        </h1>
        <p className="max-w-[700px] text-lg text-muted-foreground break-all">
          {siteConfig.heading_two}
        </p>
      </div>
      <div className="flex gap-4">
        <Link
          target="_blank"
          rel="noreferrer"
          href={siteConfig.links.github}
          className={buttonVariants({variant: "outline"})}
        >
          GitHub
          <Icons.gitHub className=" ml-3 h-5 w-5"/>
        </Link>
      </div>
    </section>
  )
}
