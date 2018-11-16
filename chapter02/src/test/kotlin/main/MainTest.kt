package main

import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class MainTestKt {

    private val main = Main()

    @Test
    fun usualLogic() {
        assertThat(main.usualLogic(true, true, false), equalTo(true))
    }

    @Test
    fun unUsualLogic() {
        assertThat(listOf("1", 2), hasItem(2))
    }

    @Test
    fun nestedLogic() {
    }
}