  # Emitting class Main {...}
    # Emitting void main(...) {...}
.LC0:
    .string "%d"
.LC1:
    .string "\n"
    .globl _main

_main:
    pushl %ebp
    movl %esp, %ebp
      # Emitting (...)
        # Emitting i0 = 0
          # Emitting i0
          addl $-4, %esp
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
          pushl %esi
          pushl %edx
          movl 4(%esp), %esi
          addl 0(%esp), %esi
        movl %esi, -4(%ebp)
        # Emitting write(i0)
          # Emitting i0
          movl -4(%ebp), %edi
        pushl %edi
        call _printf
    movl $0, %eax
    leave
    ret
