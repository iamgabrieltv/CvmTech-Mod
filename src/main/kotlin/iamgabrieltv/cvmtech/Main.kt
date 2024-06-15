package iamgabrieltv.cvmtech

import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.text.Text
import net.minecraft.util.Identifier
import org.slf4j.LoggerFactory

object Main : ModInitializer {
    private val logger = LoggerFactory.getLogger("CvmTech")

	// instance of new item
	private val cvmphone_18 = Cvmphone_18(Item.Settings().maxCount(1))

	private fun CvmGroup(): ItemGroup = FabricItemGroup.builder()
		.icon { ItemStack(cvmphone_18) }
		.displayName(Text.translatable("itemGroup.cvmtech.cvmGroup"))
		.entries { _, entries ->
			entries.add(cvmphone_18)
		}
		.build()

	override fun onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		logger.info("CvmTech Mod made by IamGabrielTV")

		Registry.register(Registries.ITEM, Identifier("cvmtech", "cvmphone_18"), cvmphone_18)
		Registry.register(Registries.ITEM_GROUP, Identifier("cvmtech", "cvmgroup"), CvmGroup())
	}
}