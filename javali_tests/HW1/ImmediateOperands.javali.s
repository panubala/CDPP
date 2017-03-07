  # Emitting class Main {...}
    # Emitting void main(...) {...}
.LC0:
    .string "%d"
.LC1:
    .string "\n"
.LC2:
    .string "%d"
    .globl _main

_main:
    pushl %ebp
    movl %esp, %ebp
      # Emitting (...)
        # Emitting i0 = 0
          # Emitting i0
          subl $4, %esp
          # Emitting 0
          movl $0, %esi
        movl %esi, -4(%ebp)
        # Emitting i0 = (5 + i0)
          # Emitting i0
          movl -4(%ebp), %edi
          # Emitting (5 + i0)
            # Emitting 5
            movl $5, %esi
            # Emitting i0
            movl -4(%ebp), %edx
          addl %edx, %esi
        movl %esi, -4(%ebp)
        # Emitting write(i0)
          # Emitting i0
          movl -4(%ebp), %edi
        pushl %edi
        pushl $.LC0
        call _printf
        addl $8, %esp
    movl %ebp, %esp
    movl $0, %eax
    popl %ebp
    ret
