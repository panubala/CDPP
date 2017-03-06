  # Emitting class Main {...}
    # Emitting void main(...) {...}
.globl _main
_main:
    pushl %ebp
    movl %esp, %ebp
      # Emitting (...)
        # Emitting x = 5
          # Emitting 5
          movl $5, %edi
          # Emitting 5
          movl $5, %esi
        movl %edi, 0(%esi)
    movl $0, %eax
    leave
    ret
