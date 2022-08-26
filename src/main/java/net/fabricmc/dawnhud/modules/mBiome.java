package net.fabricmc.dawnhud.modules;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.WorldChunk;

public class mBiome {
    public void renderBiome(MinecraftClient client, MatrixStack matrixStack) {
        String playerBiome = "";

        BlockPos pos = client.getCameraEntity().getBlockPos();
        ChunkPos chunkPos = new ChunkPos(pos);
        WorldChunk worldChunk = client.world.getChunk(chunkPos.x, chunkPos.z);

        if (worldChunk.isEmpty() == false) {
            Biome biome = client.world.getBiome(pos).value();
            Identifier id = client.world.getRegistryManager().get(Registry.BIOME_KEY).getId(biome);
            playerBiome = id.toString().substring(id.toString().lastIndexOf(":") + 1).replace("_", " ");
        }

        client.textRenderer.drawWithShadow(matrixStack, playerBiome, 5, 40, 0xFFFFFF);
    }
}