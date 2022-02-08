package PipelineRegs

import chisel3._

class EX_MEM_IO extends Bundle
{
    // Inputs
    val ld_en_in: Bool = Input(Bool())
    val str_en_in: Bool = Input(Bool())
    val rd_addr_in: UInt = Input(UInt(5.W))
    val rs2_data_in: SInt = Input(SInt(32.W))
    val alu_in: UInt = Input(UInt(24.W))
    val br_en_in: Bool = Input(Bool())
    val jal_in: Bool = Input(Bool())
    val jalr_in: Bool = Input(Bool())
    val lui_in: Bool = Input(Bool())
    val auipc_in: Bool = Input(Bool())
    val nPC_in: UInt = Input(UInt(32.W))
    
    // Outputs
    val ld_en_out: Bool = Output(Bool())
    val str_en_out: Bool = Output(Bool())
    val rd_addr_out: UInt = Output(UInt(5.W))
    val rs2_data_out: SInt = Output(SInt(32.W))
    val alu_out: UInt = Output(UInt(24.W))
    val br_en_out: Bool = Output(Bool())
    val jal_out: Bool = Output(Bool())
    val jalr_out: Bool = Output(Bool())
    val lui_out: Bool = Output(Bool())
    val auipc_out: Bool = Output(Bool())
    val nPC_out: UInt = Output(UInt(32.W))
}
class EX_MEM extends Module
{
    // Initializing the wires and modules
    val io: EX_MEM_IO = IO(new EX_MEM_IO)
    val ld_en: Bool = dontTouch(RegInit(io.ld_en_in))
    val str_en: Bool = dontTouch(RegInit(io.str_en_in))
    val rd_addr: UInt = dontTouch(RegInit(io.rd_addr_in))
    val rs2_data: SInt = dontTouch(RegInit(io.rs2_data_in))
    val alu: UInt = dontTouch(RegInit(io.alu_in))
    val br_en: Bool = dontTouch(RegInit(io.br_en_in))
    val jal: Bool = dontTouch(RegInit(io.jal_in))
    val jalr: Bool = dontTouch(RegInit(io.jalr_in))
    val lui: Bool = dontTouch(RegInit(io.lui_in))
    val auipc: Bool = dontTouch(RegInit(io.auipc_in))
    val nPC: UInt = dontTouch(RegInit(io.nPC_in))
    
    // Wiring the outputs
    Array(
        io.ld_en_out,
        io.str_en_out,
        io.rd_addr_out,
        io.rs2_data_out,
        io.alu_out,
        io.br_en_out,
        io.jal_out,
        io.jalr_out,
        io.lui_out,
        io.auipc_out,
        io.nPC_out
    ) zip Array(
        ld_en,
        str_en,
        rd_addr,
        rs2_data,
        alu,
        br_en,
        jal,
        jalr,
        lui,
        auipc,
        nPC
    ) foreach
    {
        x => x._1 := x._2
    }
}
